package com.crab.spring.aop.demo03.advice.ordering;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/7 17:24
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class OrderingTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(OrderingTest.class);
        Service1 service1 = context.getBean(Service1.class);
        // service1.hello("xxx");
        service1.throwException();
        context.close();
    }
}
