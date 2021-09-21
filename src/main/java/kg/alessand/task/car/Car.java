package kg.alessand.task.car;

import kg.alessand.task.parking.Parking;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;
    private String carNumber;
    @OneToOne
    @JoinColumn(name = "parking_id")
    private Parking parking;
    private LocalDateTime startDate;
    private boolean onParkingNow = true;
}
