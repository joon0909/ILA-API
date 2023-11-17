package site.jwhy.ila.ilaapi.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.jwhy.ila.ilaapi.entity.ResultResp;
import site.jwhy.ila.ilaapi.entity.test.TestVo;
import site.jwhy.ila.ilaapi.repository.TestRepository;
import site.jwhy.ila.ilaapi.service.TestService;
import site.jwhy.ila.ilaapi.util.HttpConnect;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;
    @Autowired
    public TestServiceImpl(TestRepository testRepository){
        this.testRepository = testRepository;
    }
    @Autowired
    public HttpConnect httpConnect;
    @Override
    public TestVo selectTestData() throws Exception{
        try{
            TestVo testVo = testRepository.selectTest();
            return testVo;

        }catch(Exception e){
            log.info(e.getMessage());
        }
        return new TestVo();
    }
    @Override
    public ResultResp selectOpenBankingCode() throws Exception{
        ResultResp test = new ResultResp();

        try{
            String apiUrl = "https://testapi.openbanking.or.kr/oauth/2.0/authorize?";
            apiUrl += "response_type=code&";
            apiUrl += "client_id=f281ea55-71bf-48ec-b78a-a6d86a03c37b&";
            apiUrl += "redirect_uri=http://localhost:8080/test/token&";
            apiUrl += "scope=login inquiry transfer&";
            apiUrl += "state=29483927182738564738129485736412&";
            apiUrl += "auth_type=0";

            Map<String, String> requestHeaders = new HashMap<>();
            requestHeaders.put("Content-Language", "ko-KR");
            requestHeaders.put("Connection", "keep-alive");
            requestHeaders.put("Transfer-Encoding", "chunked");
            requestHeaders.put("Content-Type", "text/html; charset=UTF-8");

            String resBody = httpConnect.get(apiUrl, requestHeaders);

//            JSONParser jsonParser = new JSONParser();
//            JSONObject jsonObject = (JSONObject) jsonParser.parse(resBody); // API를 통해 넘어온 JSON을 파싱


        }catch (Exception e){
            log.error(e.getMessage());
        }

        return test;
    }
}
