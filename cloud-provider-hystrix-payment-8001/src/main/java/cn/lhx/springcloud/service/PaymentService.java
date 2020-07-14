package cn.lhx.springcloud.service;

/**
 * @author lee549
 * @date 2020/7/11 16:33
 */
public interface PaymentService {
    String paymentOk(Integer id);

    String paymentTimeout(Integer id);
}
