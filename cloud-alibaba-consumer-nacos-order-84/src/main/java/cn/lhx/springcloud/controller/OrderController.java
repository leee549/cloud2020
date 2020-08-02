package cn.lhx.springcloud.controller;

import cn.lhx.springcloud.entities.JsonResult;
import cn.lhx.springcloud.entities.Payment;
import cn.lhx.springcloud.service.PaymentService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sun.org.apache.bcel.internal.generic.JSR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lee549
 * @date 2020/7/25 18:25
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping(value = "/consumer/fallback/{id}")
    // @SentinelResource(value = "fallback")//无配置
    // @SentinelResource(value = "fallback",fallback = "handlerFallback")//fallback只负责业务异常
    // @SentinelResource(value = "fallback",blockHandler = "blockHandler")//fallback只负责sentinel控制台违规，
                                                                // blockHandler.class解耦 ，blockHandler参数要一致
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")
    public JsonResult<Payment> paymentInfo(@PathVariable("id") Long id) throws IllegalAccessException {
        JsonResult<Payment> result= restTemplate.getForObject(serverUrl + "/payment/"+id,JsonResult.class);
        if (id==4){
            throw new IllegalAccessException("参数非法异常！");
        }else if (result.getData()==null){
            throw new NullPointerException("空指针异常");
        }
        return result;
    }
    //参数要一致
    public JsonResult<Object> handlerFallback(@PathVariable("id") Long id){
        return JsonResult.success(444,"handlerFallback",null);
    }

    public JsonResult<Object> blockHandler(@PathVariable("id") Long id,BlockException e){
        return JsonResult.success(445,"无此订单情况",null);
    }
    /**
     * OpenFeign
     */
    @Resource
    PaymentService paymentService;

    @GetMapping("/consumer/payment/{id}")
    public JsonResult<Object> get(@PathVariable("id") Long id) {
        return paymentService.get(id);

    }

}
