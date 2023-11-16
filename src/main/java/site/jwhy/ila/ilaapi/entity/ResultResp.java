package site.jwhy.ila.ilaapi.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResultResp<T> {
    //결과 코드 (음수: 실패 / 0: 실패 / 1: 성공)
    private Integer cd;
    private String msg;
    private List<T> data = new ArrayList<>();
}
