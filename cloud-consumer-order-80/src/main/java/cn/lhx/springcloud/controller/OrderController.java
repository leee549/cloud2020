package cn.lhx.springcloud.controller;

import cn.lhx.springcloud.LBService.LoadBalancer;
import cn.lhx.springcloud.entities.JsonResult;
import cn.lhx.springcloud.entities.Payment;
import com.sun.org.apache.bcel.internal.generic.JSR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author lee549
 * @date 2020/6/30 19:14
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/consumer/payment/create")
    public JsonResult<Object> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment", payment, JsonResult.class);
    }

    @GetMapping("/consumer/payment/{id}")
    public JsonResult<Object> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, JsonResult.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        //获取服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        //调用自己的轮询算法
        ServiceInstance serviceInstance = loadBalancer.instance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);

    }

    @GetMapping("/consumer/payment/zipkin")
    public String zipkin(){
        return restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin",String.class);
    }

}
