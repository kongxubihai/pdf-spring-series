package com.crab.spring.ioc.demo09;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/13 15:11
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Test {

@org.junit.Test
public void test() {
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);
    Service1 service1 = context.getBean(Service1.class);
    System.out.println(service1);
    context.close();
}


}
