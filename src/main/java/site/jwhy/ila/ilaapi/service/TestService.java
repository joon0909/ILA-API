package site.jwhy.ila.ilaapi.service;

import site.jwhy.ila.ilaapi.entity.ResultResp;
import site.jwhy.ila.ilaapi.entity.test.TestVo;

public interface TestService {
    TestVo selectTestData() throws Exception;
    ResultResp selectOpenBankingCode() throws Exception;
}
