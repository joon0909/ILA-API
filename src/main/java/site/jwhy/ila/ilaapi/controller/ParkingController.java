package site.jwhy.ila.ilaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.jwhy.ila.ilaapi.entity.ResultResp;
import site.jwhy.ila.ilaapi.entity.parking.ParkingLotResVo;
import site.jwhy.ila.ilaapi.entity.parking.ParkingLotVo;
import site.jwhy.ila.ilaapi.service.ParkingService;
import site.jwhy.ila.ilaapi.service.TestService;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    @Autowired
    private ParkingService parkingService;
    @Autowired
    public ParkingController(ParkingService parkingService) {this.parkingService = parkingService;}

    /**
     * PAGE     : 서울 공영주차장 목록
     * INFO     : 서울 공영주차장 목록에 대하여 표시, 서울 열린 데이터 광장 제공
     * URL      : /parkingLot/list
     * @param   : ParkingLotVo
     * @return  : ResultResp<ParkingLotResVo>
     */
    @PostMapping("/list")
    public ResultResp<ParkingLotResVo> selectParkingLotList(ParkingLotVo parkingLotVo) throws Exception{
        return parkingService.selectParkingLotList(parkingLotVo);
    }
}
