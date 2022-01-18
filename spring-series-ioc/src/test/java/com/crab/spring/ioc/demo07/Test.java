package com.crab.spring.ioc.demo07;

import javafx.geometry.VPos;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/13 15:11
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Test {

    @org.junit.Test
    public void test_java_config() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        RepositoryBase repositoryBase = context.getBean(RepositoryBase.class);
        System.out.println(repositoryBase);
    }

    @org.junit.Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo06/spring1.xml");
        context.close();
    }

    @org.junit.Test
    public void test_callback() {
        System.out.println("容器开始初始化");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig3.class);
        Service2 bean = context.getBean(Service2.class);
        System.out.println(bean);
        System.out.println("容器开始销毁");
        context.close();
    }

    @org.junit.Test
    public void test_callback_shutdown() {
        System.out.println("容器开始初始化");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig4.class);
        Service4 bean = context.getBean(Service4.class);
        System.out.println(bean);
        System.out.println("容器开始销毁");
        context.close();
    }

    @org.junit.Test
    public void test_configuration_more() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig5.class);
        RepositoryA repositoryA = context.getBean(RepositoryA.class);
        Service5 service5 = context.getBean(Service5.class);
        Service6 service6 = context.getBean(Service6.class);

        System.out.println("RepositoryA是否是同一个对象：");
        System.out.println(repositoryA);
        System.out.println(service5.getRepositoryA());
        System.out.println(service6.getRepositoryA());
        System.out.println("AppConfig5对象：");
        System.out.println(context.getBean(AppConfig5.class));
    }


}
