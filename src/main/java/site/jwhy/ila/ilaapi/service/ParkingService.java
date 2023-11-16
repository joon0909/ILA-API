package site.jwhy.ila.ilaapi.service;

import site.jwhy.ila.ilaapi.entity.ResultResp;
import site.jwhy.ila.ilaapi.entity.parking.ParkingLotResVo;
import site.jwhy.ila.ilaapi.entity.parking.ParkingLotVo;

public interface ParkingService {
    ResultResp<ParkingLotResVo> selectParkingLotList(ParkingLotVo parkingLotVo) throws Exception;
}
