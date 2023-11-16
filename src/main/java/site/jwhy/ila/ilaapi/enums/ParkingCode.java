package site.jwhy.ila.ilaapi.enums;

import org.springframework.beans.factory.annotation.Value;

public enum ParkingCode {
    API_URL("API_URL", "http://openapi.seoul.go.kr:8088"),
    API_RETURN_TYPE("RETURN_TYPE", "json"),
    API_SERVICE_NAME("API_SERVICE_NAME", "GetParkInfo");
    //GetParkingInfo : 시영 주차장 실시간 주차 대수 / GetParkInfo : 공영 주차장 정보

    private String code;
    private String value;

    ParkingCode(String code, String value){
        this.code = code;
        this.value = value;
    }

    public String getCode(){return this.code;}
    public String getValue(){return this.value;}


}
