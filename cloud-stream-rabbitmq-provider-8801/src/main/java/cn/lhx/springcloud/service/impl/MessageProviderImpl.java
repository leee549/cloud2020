package cn.lhx.springcloud.service.impl;

import cn.lhx.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author lee549
 * @date 2020/7/23 19:56
 */
@EnableBinding(Source.class) //值信道channel和交换机exchange绑定在一起，定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; //消息发送管道  此处有3中选择 output,nullChannel,errorChannel

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial: " + serial);
        return null;
    }
}
