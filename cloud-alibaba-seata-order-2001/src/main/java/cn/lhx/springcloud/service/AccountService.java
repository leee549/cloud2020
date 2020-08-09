package cn.lhx.springcloud.service;

import cn.lhx.springcloud.domain.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author lee549
 * @date 2020/8/3 22:23
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
    /**
     * 减少余额
     *
     * @return
     */
    @PostMapping("/account/decrease")
    JsonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
