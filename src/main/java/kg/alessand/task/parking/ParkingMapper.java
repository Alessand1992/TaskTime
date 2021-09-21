package kg.alessand.task.parking;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface ParkingMapper {

    ParkingMapper INSTANCE = Mappers.getMapper(ParkingMapper.class);

    Parking toParking(ParkingDto parkingDto);

    ParkingDto toParkingDto(Parking parking);

    List<Parking> toParkingList(List<ParkingDto> ParkingDtoList);

    List<ParkingDto> toParkingDtoList(List<Parking> parkingList);
}
