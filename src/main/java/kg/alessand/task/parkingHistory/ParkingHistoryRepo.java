package kg.alessand.task.parkingHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingHistoryRepo extends JpaRepository<ParkingHistory,Long> {
}
