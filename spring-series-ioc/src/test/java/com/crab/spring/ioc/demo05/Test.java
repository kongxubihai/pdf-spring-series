package com.crab.spring.ioc.demo05;

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
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo05/spring1.xml");
        ServiceA serviceA = context.getBean(ServiceA.class);
        RepositoryA repositoryA = context.getBean(RepositoryA.class);
        RepositoryB repositoryB = context.getBean(RepositoryB.class);
        System.out.println(serviceA);
        System.out.println(serviceA.getRepositoryA() == repositoryA);
        System.out.println(serviceA.getRepositoryB() == repositoryB);
        context.close();
    }

    @org.junit.Test
    public void test_by_name() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo05/spring2.xml");
        ServiceB serviceB = context.getBean(ServiceB.class);
        System.out.println(serviceB);
        context.close();
    }

}
