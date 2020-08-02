package cn.lhx.springcloud.service;

import cn.lhx.springcloud.entities.JsonResult;
import org.springframework.stereotype.Component;

/**
 * @author lee549
 * @date 2020/8/2 9:49
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public JsonResult<Object> get(Long id) {
        return JsonResult.success(444,"服务降级返回-----PaymentFallbackService",null);
    }
}
