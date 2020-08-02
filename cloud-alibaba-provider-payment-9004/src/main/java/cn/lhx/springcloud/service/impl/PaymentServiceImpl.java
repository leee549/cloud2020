package cn.lhx.springcloud.service.impl;

import cn.lhx.springcloud.dao.PaymentDao;
import cn.lhx.springcloud.entities.Payment;
import cn.lhx.springcloud.service.PaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author lee549
 * @date 2020/6/29 22:22
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentDao, Payment> implements PaymentService {
}
