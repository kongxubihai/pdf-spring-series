package com.crab.spring.ioc.demo04;

import com.crab.spring.ioc.demo03.ComplexObject;
import com.crab.spring.ioc.demo03.SimpleBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/13 15:11
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Test {

    @org.junit.Test
    public void test() {
        System.out.println("开始创建容器并初始化bean");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo04/spring1.xml");
        System.out.println("开始关闭容器并销毁bean");
        context.close();
    }

    @org.junit.Test
    public void test2() {
        System.out.println("开始创建容器并初始化bean");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo04/spring2.xml");
        System.out.println("开始关闭容器并销毁bean");
        context.close();
    }

}
