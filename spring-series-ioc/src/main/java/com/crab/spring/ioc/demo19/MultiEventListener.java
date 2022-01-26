package com.crab.spring.ioc.demo19;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 14:12
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
public class MultiEventListener {
    @EventListener({ContextStartedEvent.class, ContextRefreshedEvent.class})
    public void handleContextStart() {
        System.out.println("收到 ContextStartedEvent 或 ContextRefreshedEvent");
    }
}
