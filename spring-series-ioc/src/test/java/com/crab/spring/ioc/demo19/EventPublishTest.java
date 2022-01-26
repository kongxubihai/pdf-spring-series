package com.crab.spring.ioc.demo19;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 13:45
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class EventPublishTest {

    @Test
    public void test_synchronous() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        EmailSendService sendService = context.getBean(EmailSendService.class);
        sendService.setBlockedList(Arrays.asList("123"));
        sendService.sendEmail("123","ooo");
        sendService.sendEmail("456","ooo");
    }
}
