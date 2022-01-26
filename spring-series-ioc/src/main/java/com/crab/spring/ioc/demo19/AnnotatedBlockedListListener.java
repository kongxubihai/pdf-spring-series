package com.crab.spring.ioc.demo19;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 13:32
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
public class AnnotatedBlockedListListener{

    @Order(3)
    @EventListener(value = BlockedListEvent.class)
    public void onApplicationEvent(BlockedListEvent event) {
        System.out.println("AnnotatedBlockedListListener收到邮件禁用发送通知，地址： " + event.getAddress() + "  内容： " + event.getContent());
    }
}
