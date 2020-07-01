package cn.lhx.springcloud.controller;

import cn.lhx.springcloud.entities.JsonResult;
import cn.lhx.springcloud.entities.Payment;
import cn.lhx.springcloud.service.PaymentService;
import com.sun.org.apache.bcel.internal.generic.JSR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lee549
 * @date 2020/6/29 22:25
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment")
    public JsonResult<Object> create(@RequestBody Payment payment) {
        boolean result = paymentService.save(payment);
        log.info("****插入结果{}",result);
        if (result) {
            return JsonResult.success(200, "插入数据库成功", result);
        }else {
            return JsonResult.success(400,"插入数据库失败",null);
        }
    }
    @GetMapping("/payment/{id}")
    public JsonResult<Object> get(@PathVariable("id") Long id){
        Payment payment = paymentService.getById(id);
        log.info("****查询结果{}",payment);
        if (payment!=null) {
            return JsonResult.success(200, "查询成功", payment);
        }else {
            return JsonResult.success(400, "查询失败没有此记录", null);
        }
    }

}
