package kg.alessand.task.parkingHistory;

import kg.alessand.task.car.Car;
import kg.alessand.task.car.CarRepo;
import kg.alessand.task.parking.Parking;
import kg.alessand.task.parking.ParkingRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@AllArgsConstructor
@Service
public class ParkingHistoryServiceImpl implements ParkingHistoryService {

    private final ParkingHistoryRepo parkingHistoryRepo;
    private final ParkingRepo parkingRepo;
    private final CarRepo carRepo;

    @Override
    public ParkingHistoryDto save(ParkingHistoryDto parkingHistoryDto,Long id) {
        LocalDateTime endDate = LocalDateTime.now();
        ParkingHistory parkingHistory = ParkingHistoryMapper.INSTANCE.toParkingHistory(parkingHistoryDto);
        Car car = carRepo.getById(id);
        parkingHistory.setEndDate(endDate);
        parkingHistory.setCar(car);
        parkingHistoryRepo.save(parkingHistory);
        Parking parking = car.getParking();
        parking.setFreePlace(true);
        car.setOnParkingNow(false);
        parkingRepo.save(parking);
        carRepo.save(car);
        return ParkingHistoryMapper.INSTANCE.toParkingHistoryDto(parkingHistory);
    }
}
