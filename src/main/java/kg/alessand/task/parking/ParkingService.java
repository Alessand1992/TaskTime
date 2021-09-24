package kg.alessand.task.parking;

import kg.alessand.task.car.Car;

import java.util.List;

public interface ParkingService {


    String createPark() throws Exception;

    List<ParkingDto> findAllFreePlace() throws Exception;

    int findReservedPlaceCount() throws Exception;

    ParkingDto switchTrueOnFalse(Car car);


}
