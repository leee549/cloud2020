package cn.lhx.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.lhx.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author lee549
 * @date 2020/7/11 16:33
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    /**
     * 正常访问OK的方法
     *
     * @param id
     * @return
     */
    @Override
    public String paymentOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_ok,id:" + id + "\t";
    }

    /**
     * 模拟出错
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    public String paymentTimeout(Integer id) {
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentTimeout,id:" + id + "\t" + "耗时:" + time;
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentTimeout,id:" + id + "\t" + "/(ㄒoㄒ)/~~";

    }

    /**
     * 服务熔断
     *
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期，10s后会放一个请求试探是否成功，半开状态，成功取消熔断
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率达到多少后跳闸
    })
    public String PaymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("********id，不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentBreakerFallback(Integer id) {
        return "id，不能为负数，请稍后再试，id:" + id;
    }
}
