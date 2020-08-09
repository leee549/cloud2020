package cn.lhx.springcloud.controller;

import cn.lhx.springcloud.domain.JsonResult;
import cn.lhx.springcloud.domain.Order;
import cn.lhx.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lee549
 * @date 2020/8/3 23:21
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @RequestMapping("/order/create")
    public JsonResult<Object> create(Order order){
        orderService.create(order);
        return JsonResult.success(200,"订单创建完成",null);
    }
}
