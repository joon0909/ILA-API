package site.jwhy.ila.ilaapi.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import site.jwhy.ila.ilaapi.entity.ResultResp;
import site.jwhy.ila.ilaapi.entity.parking.ParkingLotResVo;
import site.jwhy.ila.ilaapi.entity.parking.ParkingLotVo;
import site.jwhy.ila.ilaapi.enums.ParkingCode;
import site.jwhy.ila.ilaapi.service.ParkingService;
import site.jwhy.ila.ilaapi.util.HttpConnect;

import java.util.HashMap;

@Slf4j
@Service
public class ParkingServiceImpl implements ParkingService {
//    private final TestRepository testRepository;
    @Value("${secret.api-key.seoul-open-api-key}")
    private String accessKey;
    @Autowired
    public ParkingServiceImpl(){
//        this.testRepository = testRepository;
    }
    @Autowired
    public HttpConnect httpConnect; //Open API 호출용 유틸리티
    @Override
    public ResultResp<ParkingLotResVo> selectParkingLotList(ParkingLotVo parkingLotVo) throws Exception{
        ResultResp resultResp = new ResultResp();
        try{

            String apiUrl = ParkingCode.API_URL.getValue() + "/";
            apiUrl += accessKey + "/";
            apiUrl += ParkingCode.API_RETURN_TYPE.getValue() + "/";
            apiUrl += ParkingCode.API_SERVICE_NAME.getValue() + "/";
            apiUrl += String.valueOf(parkingLotVo.getStartIndex()) + "/";
            apiUrl += String.valueOf(parkingLotVo.getEndIndex());

            //case1 : 특정 주차장 지정검색
            if(!parkingLotVo.getParkingCode().isEmpty()){
                apiUrl += "/ /" + parkingLotVo.getParkingCode();
            }
            //case2 : 지역검색
            else if(!parkingLotVo.getAddr().isEmpty() && !parkingLotVo.getAddr().equals("")){
                apiUrl += "/" + parkingLotVo.getAddr();
            }

            String resBody = httpConnect.get(apiUrl, new HashMap<>());

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(resBody); // API를 통해 넘어온 JSON을 파싱

            JSONObject parkingObject = (JSONObject) jsonObject.get(ParkingCode.API_SERVICE_NAME.getValue());
            JSONObject resultCode = (JSONObject) parkingObject.get("RESULT");

            //INFO-000 : 정상 처리 코드 / 나머지는 에러
            if(resultCode.get("CODE") == null || !resultCode.get("CODE").equals("INFO-000")){
                resultResp.setCd(0);
                resultResp.setMsg("code: " + resultCode.get("CODE") + "\\n" + "msg: " + resultCode.get("MESSAGE"));
                log.error((String) resultCode.get("MESSAGE"));
                return resultResp;
            }

            //region * getData().add(parkingObject)를 해주어도 똑같이 결과값이 리턴되지만 구조적 통일을 가져가기 위하여 "형식 지정"
            ParkingLotResVo returnVo = new ParkingLotResVo();
            returnVo.setRow(parkingObject.get("row"));
            returnVo.setListTotalCount((Long) parkingObject.get("list_total_count"));
            returnVo.setResult(resultCode);
            //endregion

            resultResp.setCd(1);
            resultResp.setMsg("주차장 정보 호출 api 정상 작동");
            resultResp.getData().add(returnVo);

        }catch(Exception e){
            log.error(e.getMessage());
            resultResp.setCd(0);
            resultResp.setMsg("외부 api 호출 실패");
        }

        return resultResp;
    }
}
