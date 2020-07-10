package cn.lhx.springcloud.service;

import cn.lhx.springcloud.entities.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lee549
 * @date 2020/7/10 10:47
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/{id}")
    JsonResult<Object> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    String PaymentFeignTimeout();
}
