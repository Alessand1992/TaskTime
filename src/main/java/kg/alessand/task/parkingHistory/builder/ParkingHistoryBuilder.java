package kg.alessand.task.parkingHistory.builder;

import kg.alessand.task.parkingHistory.ParkingHistoryDto;
import lombok.Builder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Builder
public class ParkingHistoryBuilder {
    private final Long id;
    private final Long carId;
    private final LocalDateTime endDate;
    private final String sortType;
    private final String sortProperty;

    public static ParkingHistoryBuilderBuilder getParam(ParkingHistoryDto parkingHistoryDto){

        return builder()
                .id(parkingHistoryDto.getId())
                .carId(parkingHistoryDto.getCarId())
                .endDate(parkingHistoryDto.getEndDate());


    }
}
