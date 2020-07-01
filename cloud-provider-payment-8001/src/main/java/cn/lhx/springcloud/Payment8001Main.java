package cn.lhx.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lee549
 * @date 2020/6/29 17:37
 */
@SpringBootApplication
@MapperScan("cn.lhx.springcloud.dao")
public class Payment8001Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment8001Main.class, args);
    }
}
