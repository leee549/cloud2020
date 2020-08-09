package cn.lhx.springcloud.controller;

import cn.lhx.springcloud.entities.JsonResult;
import cn.lhx.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author lee549
 * @date 2020/8/5 18:07
 */
@RestController
public class AccountController {

    @Resource
    AccountService accountService;

    @RequestMapping("/account/decrease")
    public JsonResult<Object> decrease( Long userId,  BigDecimal money) {
        accountService.decrease(userId, money);
        return JsonResult.success(200, "扣减余额成功", null);
    }
}
