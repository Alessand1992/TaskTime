package kg.alessand.task.car;

import java.util.List;

public interface CarService {

    CarDto save(CarDto carDto) throws Exception;

    List<CarDto> findAll();
}
