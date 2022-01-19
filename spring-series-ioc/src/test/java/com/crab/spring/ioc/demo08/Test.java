package com.crab.spring.ioc.demo08;

import com.crab.spring.ioc.demo07.AppConfig2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/13 15:11
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Test {

    @org.junit.Test
    public void test_component_scan1() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Service1 service1 = context.getBean(Service1.class);
        System.out.println(service1);
        context.close();
    }

    @org.junit.Test
    public void test_name_generator() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Service1 service1 = context.getBean(Service1.class);
        Arrays.stream(context.getBeanNamesForType(service1.getClass())).forEach(System.out::println);
        System.out.println(service1);
        context.close();
    }

}
