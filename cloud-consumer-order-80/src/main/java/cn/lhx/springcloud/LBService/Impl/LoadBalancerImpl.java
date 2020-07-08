package cn.lhx.springcloud.LBService.Impl;

import cn.lhx.springcloud.LBService.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lee549
 * @date 2020/7/8 21:34
 */
@Component
public class LoadBalancerImpl implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        //当前值
        int current;
        //next的值
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
            //当前值和期望值一致就修改返回true；再取反,当高并发时有可能导致当前值和期望值一致
        } while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("********第几次访问，next:"+next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
