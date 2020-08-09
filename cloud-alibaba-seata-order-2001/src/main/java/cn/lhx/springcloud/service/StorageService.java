package cn.lhx.springcloud.service;

import cn.lhx.springcloud.domain.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lee549
 * @date 2020/8/3 22:24
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    /**
     * 减少库存
     *
     * @return
     */
    @PostMapping("/storage/decrease")
    JsonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
