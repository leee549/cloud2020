package cn.lhx.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lee549
 * @date 2020/8/5 16:35
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.lhx.springcloud.dao")
@EnableFeignClients
public class SeataStorageMain2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMain2002.class,args);
    }

}
