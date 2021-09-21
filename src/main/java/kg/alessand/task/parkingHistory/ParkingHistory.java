package kg.alessand.task.parkingHistory;

import kg.alessand.task.car.Car;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "parking_history")
public class ParkingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parkingHistory_id")
    private Long id;
    @JoinColumn(name = "car_id")
    @ManyToOne
    private Car car;
    private LocalDateTime endDate;

}
