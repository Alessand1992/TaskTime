package kg.alessand.task.parking;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@AllArgsConstructor
@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingRepo parkingRepo;

    @Override
    public String createPark() {

        for (int i = 0; i <= 100; i++) {

            Parking parkPlace = new Parking();
            parkPlace.setId((long) i);
            parkPlace.setFreePlace(true);
            parkingRepo.save(parkPlace);
        }
        return "Your park was created";
    }

    @Override
    public List<ParkingDto> findAllFreePlace() {
        List<ParkingDto> parkingDtos = new ArrayList<>();
        List<Parking> findAll = parkingRepo.findAll();
        findAll.stream().filter(x-> x.isFreePlace()).forEach(x-> x.getId());
        return ParkingMapper.INSTANCE.toParkingDtoList(findAll);
    }

    @Override
    public int findReservedPlaceCount() {
        List<ParkingDto> parkingDtos = new ArrayList<>();
        List<Parking> findAll = parkingRepo.findAll();
        int z = (int) findAll.stream().filter(x-> x.isFreePlace()).count();
        int y = 100 - z;
        return y;
    }
}