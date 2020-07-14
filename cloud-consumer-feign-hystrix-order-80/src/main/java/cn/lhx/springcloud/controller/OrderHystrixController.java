package cn.lhx.springcloud.controller;

import cn.lhx.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lee549
 * @date 2020/7/11 22:16
 */
@RestController
@Slf4j
// @DefaultProperties(defaultFallback = "GlobalFallback",commandProperties = {
//                 @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService service;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id) {
        String result = service.paymentOk(id);
        return result;
    }
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    // @HystrixCommand(fallbackMethod = "paymentTimeoutFallback",commandProperties = {
    //         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    // @HystrixCommand
    public String paymentTimeout(@PathVariable("id") Integer id) {
        String result = service.paymentTimeout(id);
        return result;
    }
    public String paymentTimeoutFallback(@PathVariable("id") Integer id){
        return "端口80 调用8001接口超时，请稍后再试";
    }
    public String GlobalFallback(){
        return "全局异常处理信息，请稍后再试！";
    }


}
