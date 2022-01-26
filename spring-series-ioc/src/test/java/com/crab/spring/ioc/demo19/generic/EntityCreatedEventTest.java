package com.crab.spring.ioc.demo19.generic;

import com.crab.spring.ioc.demo19.generic.arbitrary.ArbitraryObject;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 15:14
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class EntityCreatedEventTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        context.publishEvent(new OrderEntityCreatedEvent(new Order()));
        context.publishEvent(new PersonEntityCreatedEvent(new Person()));
        context.close();
    }

    @Test
    public void test_resolvable() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        context.publishEvent(new ResolvableEntityCreatedEvent<>(new Order()));
        context.publishEvent(new ResolvableEntityCreatedEvent(new Person()));
        context.close();
    }

    @Test
    public void test_arbitrary() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        context.publishEvent(new ArbitraryObject("随意对象非ApplicationEvent事件"));
        context.close();
    }


}
