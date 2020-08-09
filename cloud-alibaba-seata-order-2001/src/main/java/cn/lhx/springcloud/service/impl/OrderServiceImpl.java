package cn.lhx.springcloud.service.impl;

import cn.lhx.springcloud.dao.OrderDao;
import cn.lhx.springcloud.domain.Order;
import cn.lhx.springcloud.service.AccountService;
import cn.lhx.springcloud.service.OrderService;
import cn.lhx.springcloud.service.StorageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lee549
 * @date 2020/8/3 17:07
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {
    @Resource
    OrderDao orderDao;
    @Resource
    AccountService accountService;
    @Resource
    StorageService storageService;
    @Override
    @GlobalTransactional(name="fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("-----------》1订单开始创建");
        orderDao.create(order);

        log.info("-----------》2调用库存 扣减------");
        storageService.decrease(order.getProductId(),order.getCount());

        log.info("-----------》3余额 扣减------");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----------》4修改订单状态");
        orderDao.update(order.getUserId(),0);

    }
}

