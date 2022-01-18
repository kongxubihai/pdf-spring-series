package com.crab.spring.ioc.demo06;

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
    public void test_annotation_config() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo06/spring2.xml");
        BeanTwo beanTwo = context.getBean(BeanTwo.class);
        System.out.println(beanTwo);
        context.close();
    }


    @org.junit.Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo06/spring1.xml");
        ServiceA serviceA = context.getBean(ServiceA.class);
        RepositoryA repositoryA = context.getBean(RepositoryA.class);
        RepositoryB repositoryB = context.getBean(RepositoryB.class);
        System.out.println(serviceA);
        System.out.println(serviceA.getRepositoryA() == repositoryA);
        System.out.println(serviceA.getRepositoryB() == repositoryB);
        context.close();
    }

    @org.junit.Test
    public void test_autowired() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo06/spring1.xml");
        Service1 bean = context.getBean(Service1.class);
        System.out.println(bean);
        context.close();
    }

    @org.junit.Test
    public void test_collection() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo06/spring1.xml");
        Service2 service2 = context.getBean(Service2.class);
        System.out.println(service2.getRepositoryList());
        System.out.println(service2.getRepositorySet());
        Arrays.stream(service2.getRepositoryArr()).forEach(System.out::println);
        context.close();
    }

    @org.junit.Test
    public void test_map() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo06/spring1.xml");
        System.out.println("注入map的键值对如下：");
        Service3 service3 = context.getBean(Service3.class);
        service3.printMap();
        context.close();
    }

    @org.junit.Test
    public void test_require() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo06/spring1.xml");
        Service4 service4 = context.getBean(Service4.class);
        System.out.println(service4);
        context.close();
    }

    @org.junit.Test
    public void test_qualifier() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo06/spring1.xml");
        Service7 service7 = context.getBean(Service7.class);
        System.out.println(service7);
        context.close();
    }


}
