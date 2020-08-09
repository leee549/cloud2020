package cn.lhx.springcloud.service;

import cn.lhx.springcloud.domain.Storage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author lee549
 * @date 2020/8/5 16:39
 */
public interface StorageService extends IService<Storage> {
    void decrease(Long productId,Integer count);
}
