package kg.alessand.task.parking;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;

import java.util.List;

public interface ParkingService {


    String createPark();

    List<ParkingDto> findAllFreePlace();

    int findReservedPlaceCount();

}
