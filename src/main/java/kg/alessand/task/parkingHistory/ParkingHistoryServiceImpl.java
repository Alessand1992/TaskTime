package kg.alessand.task.parkingHistory;

import kg.alessand.task.car.Car;
import kg.alessand.task.car.CarRepo;
import kg.alessand.task.car.CarService;
import kg.alessand.task.parking.Parking;
import kg.alessand.task.parking.ParkingRepo;
import kg.alessand.task.parking.ParkingService;
import kg.alessand.task.parkingHistory.builder.ParkingHistoryBuilder;
import kg.alessand.task.parkingHistory.builder.ParkingHistoryDtoBuilder;
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
    private final CarService carService;
    private final ParkingService parkingService;

    @Override
    public ParkingHistoryDto save(ParkingHistoryDto parkingHistoryDto, Long id) throws Exception {
        ParkingHistoryBuilder.ParkingHistoryBuilderBuilder parameters = ParkingHistoryBuilder.getParam(parkingHistoryDto);

        ParkingHistory parkingHistory = ParkingHistoryMapper.INSTANCE.toParkingHistory(parkingHistoryDto);
        carService.switchFalseOnTrue(id);
        parkingHistory.setCar(carRepo.getById(id));
        parkingHistory.setEndDate(LocalDateTime.now());
        parkingHistoryRepo.save(parkingHistory);
        System.out.println(parameters);
        return ParkingHistoryMapper.INSTANCE.toParkingHistoryDto(parkingHistory);
    }
}
