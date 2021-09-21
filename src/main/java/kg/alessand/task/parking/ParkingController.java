package kg.alessand.task.parking;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.alessand.task.RestResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;


import java.util.List;
import java.util.Map;

import static kg.alessand.task.config.Swagger2Config.PARKING;

@Api(tags = PARKING)
@RestController
@RequestMapping(value = "/park")
@Slf4j
@AllArgsConstructor
public class ParkingController {
    private final ParkingService parkingService;




    @ApiOperation(value = "Получить список всех мест", notes = "Получить список всех мест")
    @GetMapping("/findAllParkingPlace")
    private RestResponse<?> findAllParkingPlace() throws Exception {
        try {
            log.info("Все места на парковке");
            List<ParkingDto> parkingDtos = parkingService.findAllFreePlace();
            List<Parking> parkings = ParkingMapper.INSTANCE.toParkingList(parkingDtos);
            return RestResponse.of(HttpStatus.OK,parkings,Map.of("1","SUCCESS"));
        } catch (HttpClientErrorException.NotFound notFoundException){
            return RestResponse.of(HttpStatus.NOT_FOUND,null,Map.of("1",notFoundException.getMessage()));
        } catch (Exception e) {
            return RestResponse.of(HttpStatus.BAD_REQUEST,null,Map.of("1",e.getMessage()));
        }

    }


    @ApiOperation(value = "Получить список занятых мест", notes = "Получить список занятых мест")
    @GetMapping("/findAllReserved")
    private RestResponse<?> findAllReserved(){
        try {
            log.info("Поиск всех занятых мест");
            int parkingDtos = parkingService.findReservedPlaceCount();
            return RestResponse.of(HttpStatus.OK,parkingDtos,Map.of("1","SUCCESS"));
        } catch (Exception e){
            return RestResponse.of(HttpStatus.BAD_REQUEST,null,Map.of("1",e.getMessage()));
        }
    }


    @ApiOperation(value = "Создать парк на 100 мест", notes = "Создать парк на 100 мест")
    @PostMapping("/createParkingBuilding")
    private RestResponse<?> createParkingBuilding() throws Exception {
        try {
            log.info("Успешно создан автопарк на 100 машин!");
            return RestResponse.of(HttpStatus.OK,parkingService.createPark(), Map.of("1","SUCCESS"));
        } catch (Exception e) {
            log.info("Произошла ошибки при создании парковки");
            return RestResponse.of(HttpStatus.BAD_REQUEST,null,Map.of("1","Error"));
        }
    }





}



//    @PostMapping("/createParkingBuilding")
//    private String createPark() throws Exception {
//        try {
//            log.info("Успешно создан автопарк на 100 машин!");
//            return parkingService.createPark();
//        }catch (Exception e){
//            throw  new Exception("Произошла ошибка в создании парковки");
//        }
//    }
//    @GetMapping("/findAllFreePlace")
//    private List<ParkingDto> findAllFreePlace() throws Exception {
//        try {
//            log.info("Найдены все свободные места!");
//            return parkingService.findAllFreePlace();
//        }catch (Exception e){
//            throw new Exception("Произошла Ошибка в поиске Всех свободных мест");
//        }
//    }
//
//
//    @GetMapping("/findAllReservedPlacesCount")
//    private int findAllReservedPlacesCount() throws Exception {
//        try {
//            log.info("Успешно подсчитаны все свободные места");
//            return parkingService.findReservedPlaceCount();
//        }catch (Exception e){
//            throw new Exception("Произошла ошибка при подсчете занятых мест");
//        }
//    }