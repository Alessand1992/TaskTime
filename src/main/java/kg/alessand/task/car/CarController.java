package kg.alessand.task.car;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.alessand.task.RestResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static kg.alessand.task.config.Swagger2Config.CAR;

@Api(tags = CAR)
@RestController
@RequestMapping(value = "/car")
@Slf4j
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @ApiOperation(value = "Оставить машину на парковке", notes = "Оставить машину на парковке")
    @GetMapping("/carSave")
    private RestResponse<?> carSave(CarDto carDto) throws Exception {
        try {
            log.info("Машина успешно сохранена!");
            return RestResponse.of(HttpStatus.OK, carService.save(carDto), Map.of("1", "Машина успешно сохранена"));
        } catch (ArrayStoreException e) {
            return RestResponse.of(HttpStatus.BAD_REQUEST, null, Map.of("1", "Все места заняты"));
        } catch (Exception e) {
            return RestResponse.of(HttpStatus.BAD_REQUEST, null, Map.of("1", e.getMessage()));
        }
    }

    @ApiOperation(value = "Найти все машины", notes = "Найти все машины")
    @GetMapping("/carFound")
    private RestResponse<?> carFound() throws Exception {
        try {
            return RestResponse.of(HttpStatus.OK, carService.findAll(), Map.of("1", "Success"));
        } catch (Exception e) {
            return RestResponse.of(HttpStatus.BAD_REQUEST, null, Map.of("1", e.getMessage()));
        }
    }


//    @ApiOperation(value = "Сохранить машину на парковке")
//    @PostMapping("/saveCarOnParking")
//    private CarDto save(CarDto carDto) throws Exception {
//        try {
//            log.info("Машина успешно сохранена!");
//            return carService.save(carDto);
//        } catch (ArrayStoreException e){
//            throw new Exception("Все места на парковке заняты");
//        }  catch (Exception e){
//            throw new Exception("Произошла ошибка при сохранении");
//        }
//    }
//    @GetMapping("/findAllCars")
//    private List<CarDto> findAll() throws Exception {
//        try {
//            log.info("Машины найдены!");
//            return carService.findAll();
//        } catch (RuntimeException e){
//            throw new RuntimeException();
//        } catch (Exception e){
//            throw new Exception("Произошла ошибка при поиске всех машин");
//        }
//    }
}
