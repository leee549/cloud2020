package cn.lhx.springcloud.service.impl;

import cn.lhx.springcloud.dao.AccountDao;
import cn.lhx.springcloud.domain.Account;
import cn.lhx.springcloud.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author lee549
 * @date 2020/8/5 18:01
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountDao, Account> implements AccountService {
    @Resource
    AccountDao accountDao;
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);


    @Override
    public void decrease(Long userId, BigDecimal money) {
        logger.info("---------------account扣减余额开始");
        try {
            TimeUnit.SECONDS.sleep(5);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        accountDao.decrease(userId,money);
        logger.info("---------------account扣减余额结束");

    }
}
