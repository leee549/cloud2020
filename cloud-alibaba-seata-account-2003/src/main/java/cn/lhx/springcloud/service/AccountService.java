package cn.lhx.springcloud.service;

import cn.lhx.springcloud.domain.Account;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
 * @author lee549
 * @date 2020/8/5 18:01
 */
public interface AccountService extends IService<Account> {
    void decrease(Long userId, BigDecimal money);

}
