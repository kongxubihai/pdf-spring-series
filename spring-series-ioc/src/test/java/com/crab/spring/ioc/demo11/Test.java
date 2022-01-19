package com.crab.spring.ioc.demo11;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/19 14:02
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Test {

    @org.junit.Test
    public void test1() {
        System.out.println("开始初始化容器");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo11/spring.xml");
        System.out.println("容器使用中----");
        BeanOne beanOne = context.getBean(BeanOne.class);
        System.out.println(beanOne);
        System.out.println("开始销毁容器");
        context.close();
        System.out.println("结束销毁容器");
    }

    @org.junit.Test
    public void test2() {
        System.out.println("开始初始化容器");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo11/spring2.xml");
        System.out.println("容器使用中----");
        BeanTwo beanOne = context.getBean(BeanTwo.class);
        System.out.println(beanOne);
        System.out.println("开始销毁容器");
        context.close();
        System.out.println("结束销毁容器");
    }

    @org.junit.Test
    public void test3() {
        System.out.println("开始初始化容器");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo11/spring3.xml");
        System.out.println("容器使用中----");
        BeanThree beanOne = context.getBean(BeanThree.class);
        System.out.println(beanOne);
        System.out.println("开始销毁容器");
        context.close();
        System.out.println("结束销毁容器");
    }

    @org.junit.Test
    public void test_lifecycle() throws InterruptedException {
        System.out.println("开始初始化容器");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo11/spring4.xml");
        context.start();
        System.out.println("容器使用中----");
        MyBeanOne beanOne = context.getBean(MyBeanOne.class);
        System.out.println(beanOne);
        System.out.println("开始销毁容器");
        context.stop();
        TimeUnit.SECONDS.sleep(2);
        context.close();
        System.out.println("结束销毁容器");
    }
    @org.junit.Test
    public void test_aware() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        BeanFour bean = context.getBean(BeanFour.class);
        System.out.println(bean.getContext() == context);
        context.close();
    }
    @org.junit.Test
    public void test_aware2() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        BeanFour2 bean = context.getBean(BeanFour2.class);
        System.out.println(bean.getContext() == context);
        context.close();
    }





}
