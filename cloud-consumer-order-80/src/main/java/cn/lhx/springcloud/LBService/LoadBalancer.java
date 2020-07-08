package cn.lhx.springcloud.LBService;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author lee549
 * @date 2020/7/8 21:32
 */
public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
