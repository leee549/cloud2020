package cn.lhx.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lee549
 * @date 2020/7/17 13:57
 */
@RestController
@RefreshScope
public class ConfigController {
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig(){
        return applicationName+"\t"+eurekaServers+"\t"+port;
    }


}
