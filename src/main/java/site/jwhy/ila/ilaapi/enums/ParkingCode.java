package site.jwhy.ila.ilaapi.enums;

import org.springframework.beans.factory.annotation.Value;

public enum ParkingCode {
    API_URL("API_URL", "http://openapi.seoul.go.kr:8088"),
    API_RETURN_TYPE("RETURN_TYPE", "json"),
    API_SERVICE_NAME("API_SERVICE_NAME", "GetParkInfo");


    private String code;
    private String value;

    ParkingCode(String code, String value){
        this.code = code;
        this.value = value;
    }

    public String getCode(){return this.code;}
    public String getValue(){return this.value;}


}
