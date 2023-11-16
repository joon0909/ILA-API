package site.jwhy.ila.ilaapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@MapperScan(basePackages = {"site.jwhy.ila.ilaapi.repository"})
@SpringBootApplication
public class IlaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(IlaApiApplication.class, args);
    }

}
