package cn.lhx.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author lee549
 * @date 2020/7/14 10:02
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentOk(Integer id) {
        return "PaymentFallbackService------down";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "PaymentFallbackService------down";
    }
}
