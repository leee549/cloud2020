package cn.lhx.springcloud.service;

import cn.lhx.springcloud.domain.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author lee549
 * @date 2020/8/3 17:06
 */
public interface OrderService extends IService<Order> {
    /**
     * 新建订单
     */
    void create(Order order);
}
