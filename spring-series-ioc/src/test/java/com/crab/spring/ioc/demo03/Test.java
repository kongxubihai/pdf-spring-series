package com.crab.spring.ioc.demo03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/13 15:11
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Test {

    @org.junit.Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo03/spring.xml");
        SimpleBean simpleBean = context.getBean(SimpleBean.class);
        System.out.println(simpleBean);
        System.out.println("演示集合：");
        ComplexObject complexObject = context.getBean(ComplexObject.class);
        System.out.println(complexObject);
    }
}
