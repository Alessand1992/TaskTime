package kg.alessand.task.car;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    Car toCar(CarDto carDto);

    CarDto carDto(Car car);

    List<CarDto> toCarList(List<CarDto> CarDtoList);

    List<CarDto> toCarDtoList(List<Car> carList);
}