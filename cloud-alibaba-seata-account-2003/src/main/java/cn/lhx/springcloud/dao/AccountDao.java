package cn.lhx.springcloud.dao;

import cn.lhx.springcloud.domain.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author lee549
 * @date 2020/8/5 16:38
 */
public interface AccountDao extends BaseMapper<Account> {

    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
