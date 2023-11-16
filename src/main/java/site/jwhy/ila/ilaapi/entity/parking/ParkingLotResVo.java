package site.jwhy.ila.ilaapi.entity.parking;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ParkingLotResVo {
    private Object row;
    private Long listTotalCount = 0L;
    private Object result;
}
