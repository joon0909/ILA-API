package site.jwhy.ila.ilaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.jwhy.ila.ilaapi.entity.test.TestVo;
import site.jwhy.ila.ilaapi.service.TestService;

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

}
