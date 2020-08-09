package cn.lhx.springcloud.service.impl;

import cn.lhx.springcloud.dao.StorageDao;
import cn.lhx.springcloud.domain.Storage;
import cn.lhx.springcloud.service.StorageService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lee549
 * @date 2020/8/5 16:41
 */
@Service
public class StorageServiceImpl extends ServiceImpl<StorageDao, Storage> implements StorageService {
    @Resource
    StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId,count);
    }
}
