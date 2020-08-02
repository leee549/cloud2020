package cn.lhx.springcloud.controller;

import cn.lhx.springcloud.entities.JsonResult;
import cn.lhx.springcloud.entities.Payment;
import cn.lhx.springcloud.handler.BlockHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sun.deploy.security.BlockedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lee549
 * @date 2020/7/31 10:35
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResources")
    @SentinelResource(value = "byResources",blockHandler = "handlerException")
    public JsonResult<Object> byResources(){
        return JsonResult.success(200,"按资源名限流测试OK",new Payment(2020L,"serial2020"));
    }
    public JsonResult<Object> handlerException(BlockException e){
        return JsonResult.success(400,e.getClass().getCanonicalName()+"\t 访问不可用",null);
    }

    /*全局异常*/

    @GetMapping("/blockHandler")
    @SentinelResource(value = "blockHandler",
            blockHandlerClass = BlockHandler.class,
            blockHandler = "handlerException2")
    public JsonResult<Object> blockHandler(){
        return JsonResult.success(200,"按资源名限流测试OK",new Payment(2020L,"serial2020"));
    }

}
