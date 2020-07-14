package cn.lhx.springcloud.controller;

import cn.lhx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lee549
 * @date 2020/7/11 16:39
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id) {
        String result = paymentService.paymentOk(id);
        log.info("******result: {}",result);
        return result;
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id) {
        String result = paymentService.paymentTimeout(id);
        log.info("******result: {}",result);
        return result;
    }
    //熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuit(@PathVariable("id") Integer id){
        return paymentService.PaymentCircuitBreaker(id);
    }
}
