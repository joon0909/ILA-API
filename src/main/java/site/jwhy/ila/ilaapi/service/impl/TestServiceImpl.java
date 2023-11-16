package site.jwhy.ila.ilaapi.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.jwhy.ila.ilaapi.entity.test.TestVo;
import site.jwhy.ila.ilaapi.repository.TestRepository;
import site.jwhy.ila.ilaapi.service.TestService;
@Slf4j
@Service
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;
    @Autowired
    public TestServiceImpl(TestRepository testRepository){
        this.testRepository = testRepository;
    }
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
}
