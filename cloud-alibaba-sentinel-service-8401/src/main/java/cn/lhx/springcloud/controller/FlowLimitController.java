package cn.lhx.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lee549
 * @date 2020/7/29 11:18
 */
@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(800);
        return "TestA";
    }
    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+"/testB");
        return "TestB";
    }
    @GetMapping("/testC")
    public String testC() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1000);
        log.info(Thread.currentThread().getName()+"/testC");
        return "TestC";
    }
    @GetMapping("/testD")
    public String testD() throws InterruptedException {
        int x = 1/0;
        log.info(Thread.currentThread().getName()+"/testC");
        return "TestC";
    }
}
