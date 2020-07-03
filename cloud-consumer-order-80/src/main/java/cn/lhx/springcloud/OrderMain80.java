package cn.lhx.springcloud;

import cn.lhx.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author lee549
 * @date 2020/6/30 16:12
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE" , configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
