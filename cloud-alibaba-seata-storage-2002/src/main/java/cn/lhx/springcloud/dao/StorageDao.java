package cn.lhx.springcloud.dao;

import cn.lhx.springcloud.domain.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lee549
 * @date 2020/8/5 16:38
 */
public interface StorageDao extends BaseMapper<Storage> {

    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
