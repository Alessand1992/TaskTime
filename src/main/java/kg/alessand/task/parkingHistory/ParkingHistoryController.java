package kg.alessand.task.parkingHistory;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.alessand.task.RestResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static kg.alessand.task.config.Swagger2Config.PARKING_HISTORY;

@Api(tags = PARKING_HISTORY)
@RestController
@RequestMapping(value = "/parkingHistory")
@Slf4j
@AllArgsConstructor
public class ParkingHistoryController {
    private final ParkingHistoryService parkingHistoryService;


    @ApiOperation(value = "Машина покидает парковку", notes = "Машина покидает парковку")
    @GetMapping("/saveParkingHistory")
    private RestResponse<?> saveParkingHistory(ParkingHistoryDto parkingHistoryDto,Long id) throws Exception {
        try{
            parkingHistoryService.save(parkingHistoryDto,id);
            return RestResponse.of(HttpStatus.OK,parkingHistoryService.save(parkingHistoryDto,id), Map.of("1","SUCCESS"));
        }catch (Exception e){
            return RestResponse.of(HttpStatus.OK,null,Map.of("1",e.getMessage()));
        }
    }

//    @PostMapping("/parkingHistorySave")
//    private ParkingHistoryDto save(ParkingHistoryDto parkingHistoryDto,Long id) throws Exception {
//        try {
//            log.info("Машина успешна сохранена в истории");
//            return parkingHistoryService.save(parkingHistoryDto, id);
//        }catch (Exception e){
//            throw new Exception("Ошибка в сохранении истории машин на парковке");
//        }
//    }



}
