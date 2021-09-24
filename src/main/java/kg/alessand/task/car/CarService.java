package kg.alessand.task.car;

import kg.alessand.task.parking.Parking;

import java.util.List;

public interface CarService {

    CarDto save(CarDto carDto) throws Exception;

    List<CarDto> findAll();

    CarDto switchFalseOnTrue(Long id) throws Exception;


}
