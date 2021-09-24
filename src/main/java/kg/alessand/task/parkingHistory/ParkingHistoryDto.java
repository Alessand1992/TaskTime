package kg.alessand.task.parkingHistory;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParkingHistoryDto {

    private Long id;
    private Long carId;
    private LocalDateTime endDate;
}
