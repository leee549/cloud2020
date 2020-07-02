package cn.lhx.springcloud.controller;

import cn.lhx.springcloud.entities.JsonResult;
import cn.lhx.springcloud.entities.Payment;
import com.sun.org.apache.bcel.internal.generic.JSR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lee549
 * @date 2020/6/30 19:14
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public JsonResult<Object> create( Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment",payment,JsonResult.class);
    }
    @GetMapping("/consumer/payment/{id}")
    public JsonResult<Object> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id,JsonResult.class);
    }

}
