package cn.lhx.springcloud.controller;

import cn.lhx.springcloud.domain.JsonResult;
import cn.lhx.springcloud.service.StorageService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lee549
 * @date 2020/8/5 17:18
 */
@RestController
public class StorageController {
    @Resource
    StorageService storageService;

    @RequestMapping("/storage/decrease")
    public JsonResult<Object> decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return JsonResult.success(200, "扣减库存成功", null);
    }
}
