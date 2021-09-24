package kg.alessand.task.car;

import kg.alessand.task.parking.Parking;
import kg.alessand.task.parking.ParkingRepo;
import kg.alessand.task.parking.ParkingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class CarServiceImpl implements CarService {

    private final CarRepo carRepo;
    private final ParkingRepo parkingRepo;
    private final ParkingService parkingService;

    @Override
    public CarDto save(CarDto carDto) throws Exception {
        try {
            Car car = CarMapper.INSTANCE.toCar(carDto);
            Parking parkingId = parkingRepo.findAll().stream().filter(x -> x.isFreePlace()).findFirst().get();
            if(parkingId == null){
                throw new Error("Места на парковке");
            }
            car.setParking(parkingId);
            car.setStartDate(LocalDateTime.now());
            carRepo.save(car);
            parkingId.setFreePlace(false);
            parkingRepo.save(parkingId);
            return CarMapper.INSTANCE.carDto(car);
        }catch (Exception e){
            throw new Exception("Ошибка при сохранении машины на парковке");
        }
    }

    @Override
    public List<CarDto> findAll() {
        List<Car> cars = carRepo.findAll();
        return CarMapper.INSTANCE.toCarDtoList(cars);
    }

    @Override
    public CarDto switchFalseOnTrue(Long id) throws Exception {
        try {
            Car car = carRepo.getById(id);
            car.setOnParkingNow(false);
            parkingService.switchTrueOnFalse(car);
            carRepo.save(car);
//            Parking parking = car.getParking();
//            parking.setFreePlace(true);
//            parkingRepo.save(parking);
            return CarMapper.INSTANCE.carDto(car);
        }catch (Exception e){
            throw new Exception("Возникла ошибка !");
        }
    }

}
