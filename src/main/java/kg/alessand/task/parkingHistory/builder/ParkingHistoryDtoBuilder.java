package kg.alessand.task.parkingHistory.builder;

import kg.alessand.task.car.Car;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParkingHistoryDtoBuilder {

    private Long id;
    private Car car;
    private LocalDateTime endDate;
}
