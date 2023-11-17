package site.jwhy.ila.ilaapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.jwhy.ila.ilaapi.entity.ResultResp;
import site.jwhy.ila.ilaapi.entity.test.TestVo;
import site.jwhy.ila.ilaapi.service.TestService;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    public TestController(TestService testService) {this.testService = testService;}

    @GetMapping("/")
    public TestVo selectTestData() throws Exception{
        TestVo testVo = testService.selectTestData();

        return testVo;
    }
    @GetMapping("/openbanking")
    public ResultResp selectOpenBankingCode() throws Exception{
        ResultResp test = testService.selectOpenBankingCode();

        return test;
    }
    @GetMapping("/token")
    public ResultResp selectToken() throws Exception{
        ResultResp test = new ResultResp();

        {
            "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDQwODEwIiwic2NvcGUiOlsiY2FyZGluZm8iLCJmaW50ZWNoaW5mbyIsImlucXVpcnkiLCJsb2dpbiIsInRyYW5zZmVyIl0sImlzcyI6Imh0dHBzOi8vd3d3Lm9wZW5iYW5raW5nLm9yLmtyIiwiZXhwIjoxNzA3OTcxNDkzLCJqdGkiOiJhNDIyMGZhOC02OWZhLTQxYTItOWI1Ny1hY2VjYTFiOGUyYTgifQ.qt-Oot0RvU3RIxImXmcLoz_0CjSNi3ukWmkrXHUAoVE",
            "token_type": "Bearer",
            "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDQwODEwIiwic2NvcGUiOlsiY2FyZGluZm8iLCJmaW50ZWNoaW5mbyIsImlucXVpcnkiLCJsb2dpbiIsInRyYW5zZmVyIl0sImlzcyI6Imh0dHBzOi8vd3d3Lm9wZW5iYW5raW5nLm9yLmtyIiwiZXhwIjoxNzA4ODM1NDkzLCJqdGkiOiI5MTAxNDlmYS04NmNiLTRjMGUtYmM5Mi0wODY5NGE3OWVhMGMifQ.kz8zptyimz0AcarCYUrydgwcR5uywEkalcNhBG-D9_U",
            "expires_in": 7775999,
            "scope": "cardinfo fintechinfo inquiry login transfer",
            "user_seq_no": "1101040810"
        }

        return test;
    }
}
