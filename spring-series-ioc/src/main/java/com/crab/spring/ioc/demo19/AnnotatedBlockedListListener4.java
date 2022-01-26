package com.crab.spring.ioc.demo19;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 事件监听器
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 13:32
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
@EnableAsync // 启用Spring异步处理
public class AnnotatedBlockedListListener4 {

    @Async // 标记方法为异步
    @EventListener(value = BlockedListEvent.class)
    public void onApplicationEvent(BlockedListEvent event) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("异步处理收到邮件禁用发送通知，地址： " + event.getAddress() + "  内容： " + event.getContent());
    }
}
