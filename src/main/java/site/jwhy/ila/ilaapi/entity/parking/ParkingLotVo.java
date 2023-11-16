package site.jwhy.ila.ilaapi.entity.parking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingLotVo {
    //서울 데이터 광장 - 서울시 공영주차장 안내 정보 API param
    //API명세서 https://data.seoul.go.kr/dataList/OA-13122/S/1/datasetView.do
    private String key = "";
    private String type = "";
    private String service = "";
    private Integer startIndex = 0;
    private Integer endIndex = 0;
    private String addr = "";
    private String parkingCode = "";
}
