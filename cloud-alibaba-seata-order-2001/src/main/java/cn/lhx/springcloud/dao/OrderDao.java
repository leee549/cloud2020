package cn.lhx.springcloud.dao;

import cn.lhx.springcloud.domain.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lee549
 * @date 2020/8/3 17:05
 */
public interface OrderDao extends BaseMapper<Order> {
    void create(Order order);

    void update(@Param("userId")Long userId,@Param("status")Integer status);
}
