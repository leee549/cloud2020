package cn.lhx.springcloud.controller;

import cn.lhx.springcloud.entities.JsonResult;
import cn.lhx.springcloud.entities.Payment;
import cn.lhx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lee549
 * @date 2020/6/29 22:25
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment")
    public JsonResult<Object> create(@RequestBody Payment payment) {
        boolean result = paymentService.save(payment);
        log.info("****插入结果{}", result);
        if (result) {
            return JsonResult.success(200, "插入数据库成功,serverPort" + serverPort, result);
        } else {
            return JsonResult.success(400, "插入数据库失败", null);
        }
    }

    @GetMapping("/payment/{id}")
    public JsonResult<Object> get(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);
        log.info("****查询结果{}", payment);
        if (payment != null) {
            return JsonResult.success(200, "查询成功,serverPort" + serverPort, payment);
        } else {
            return JsonResult.success(400, "查询失败没有此记录", null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*********element: {}", element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getHost() + "\t" + instance.getUri() + "\t" + instance.getPort() + "\t" + instance.getServiceId());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String PaymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serverPort;
    }
    @GetMapping("/payment/zipkin")
    public String zipkin(){
        return "success ! zipkin";
    }
}
