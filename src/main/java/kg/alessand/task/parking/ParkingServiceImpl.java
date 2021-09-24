package kg.alessand.task.parking;

import kg.alessand.task.car.Car;
import kg.alessand.task.car.CarDto;
import kg.alessand.task.car.CarRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingRepo parkingRepo;
    private final CarRepo carRepo;

    @Override
    public String createPark() throws Exception {

        try {
//            while (true) {
//                int i = +1;
//                Parking parkPlace = new Parking();
//                parkPlace.setId((long) i);
//                parkPlace.setFreePlace(true);
//                parkingRepo.save(parkPlace);
//                if (i == 100) {
//                    break;
//                }
            for (int i = 0; i <= 100; i++) {

                Parking parkPlace = new Parking();
                parkPlace.setId((long) i);
                parkPlace.setFreePlace(true);
                parkingRepo.save(parkPlace);
            }
            return "Your park was created";
        } catch (Exception e) {
            throw new Exception("Непредвиденная ошибка в создании парковки");
        }
    }

    @Override
    public List<ParkingDto> findAllFreePlace() throws Exception {
        try {
            List<ParkingDto> parkingDtos = new ArrayList<>();
            List<Parking> findAll = parkingRepo.findAll();
            findAll.stream().filter(x -> x.isFreePlace()).forEach(x -> x.getId());
            return ParkingMapper.INSTANCE.toParkingDtoList(findAll);
        }catch (Exception e){
            throw  new Exception("Непредвиденная ошибка в поиске свободных мест");
        }
    }

    @Override
    public int findReservedPlaceCount() throws Exception {
        try {
            List<ParkingDto> parkingDtos = new ArrayList<>();
            List<Parking> findAll = parkingRepo.findAll();
            int z = (int) findAll.stream().filter(x -> x.isFreePlace()).count();
            int y = 100 - z;
            return y;
        }catch (Exception e){
            throw new Exception("Ошибка в поиске занятых мест");
            }
        }

    @Override
    public ParkingDto switchTrueOnFalse(Car car) {
        Parking parking = car.getParking();
        parking.setFreePlace(true);
        parkingRepo.save(parking);
        return ParkingMapper.INSTANCE.toParkingDto(parking);
    }



}


//            for (int i = 0; i <= 100; i++) {
//
//                Parking parkPlace = new Parking();
//                parkPlace.setId((long) i);
//                parkPlace.setFreePlace(true);
//                parkingRepo.save(parkPlace);