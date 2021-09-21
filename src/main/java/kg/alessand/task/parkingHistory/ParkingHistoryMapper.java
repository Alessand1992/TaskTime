package kg.alessand.task.parkingHistory;

import kg.alessand.task.parking.Parking;
import kg.alessand.task.parking.ParkingDto;
import kg.alessand.task.parking.ParkingMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ParkingHistoryMapper {

    ParkingHistoryMapper INSTANCE = Mappers.getMapper(ParkingHistoryMapper.class);

    ParkingHistory toParkingHistory(ParkingHistoryDto parkingHistoryDto);

    ParkingHistoryDto toParkingHistoryDto(ParkingHistory parkingHistory);

    List<ParkingHistory> toParkingHistoryList(List<ParkingHistoryDto> ParkingHistoryDtoList);

    List<ParkingHistoryDto> toParkingDtoHistoryList(List<ParkingHistory> parkingHistoryList);
}
