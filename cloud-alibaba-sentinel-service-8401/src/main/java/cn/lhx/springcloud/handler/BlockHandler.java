package cn.lhx.springcloud.handler;

import cn.lhx.springcloud.entities.JsonResult;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author lee549
 * @date 2020/7/31 11:50
 */
public class BlockHandler {
    public static JsonResult<Object> handlerException2(BlockException e){
        return JsonResult.success(400,"\t自定义 访问不可用",null);
    }
}
