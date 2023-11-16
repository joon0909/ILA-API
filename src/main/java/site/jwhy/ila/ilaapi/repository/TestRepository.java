package site.jwhy.ila.ilaapi.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import site.jwhy.ila.ilaapi.entity.test.TestVo;
@Repository
public interface TestRepository {
    TestVo selectTest() throws DataAccessException;
}
