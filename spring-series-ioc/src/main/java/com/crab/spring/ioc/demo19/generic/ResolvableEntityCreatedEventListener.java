package com.crab.spring.ioc.demo19.generic;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 15:12
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
public class ResolvableEntityCreatedEventListener {

    @EventListener
    public void onPersonCreated(ResolvableEntityCreatedEvent<Person> event) {
        System.out.println("onPersonCreated Resolvable");
    }

    @EventListener
    public void onOrderCreated(ResolvableEntityCreatedEvent<Order> event) {
        System.out.println("onOrderCreated Resolvable");
    }
}
