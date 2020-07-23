package cn.lhx.springcloud.controller;

import cn.lhx.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lee549
 * @date 2020/7/23 20:11
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    public String send(){
        return messageProvider.send();
    }
}
