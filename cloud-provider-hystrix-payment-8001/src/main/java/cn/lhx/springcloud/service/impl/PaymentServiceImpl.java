package cn.lhx.springcloud.service.impl;

import cn.lhx.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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
     * @param id
     * @return
     */
    @Override
    public String paymentOk(Integer id) {
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_ok,id:"+id+"\t";
    }
    /**
     * 模拟出错
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    public String paymentTimeout(Integer id) {
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentTimeout,id:" + id + "\t"+"耗时:"+time;
    }
    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "paymentTimeout,id:" + id +"\t"+"/(ㄒoㄒ)/~~";

    }
}
