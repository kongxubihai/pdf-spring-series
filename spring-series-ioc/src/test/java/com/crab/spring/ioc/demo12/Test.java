package com.crab.spring.ioc.demo12;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/20 11:25
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Test {

    @org.junit.Test
    public void test1() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        BeanOne bean = context.getBean(BeanOne.class);
        System.out.println(bean);
        context.close();
    }

    @org.junit.Test
    public void test_bfpp1() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig2.class);
        MyDataSource bean = context.getBean(MyDataSource.class);
        System.out.println(bean);
        context.close();
    }

    @org.junit.Test
    public void test_bfpp2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo12/spring.xml");
        MyDataSource bean = context.getBean(MyDataSource.class);
        System.out.println(bean);
        context.close();
    }

    @org.junit.Test
    public void test_factory_bean() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        MyFactoryBean factoryBean = context.getBean(MyFactoryBean.class);
        System.out.println(factoryBean);
        Object factoryBean2 = context.getBean("&myFactoryBean");
        System.out.println("MyFactoryBean 实例： " + factoryBean);
        System.out.println(factoryBean == factoryBean2);
        Object beanProduct1 = context.getBean("myFactoryBean");
        Object beanProduct2 = context.getBean("myFactoryBean");
        System.out.println("MyFactoryBean 生产的bean实例: " + beanProduct1);
        System.out.println(beanProduct2 == beanProduct1);
    }
}
