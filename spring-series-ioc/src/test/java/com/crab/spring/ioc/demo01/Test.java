package com.crab.spring.ioc.demo01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/13 13:32
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Test {

    @org.junit.Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo01/spring.xml");
        ConstructorBean constructorBean = context.getBean(ConstructorBean.class);
        System.out.println(constructorBean);
        System.out.println("测试静态工厂方法实例化类");
        StaticBean staticBean = context.getBean(StaticBean.class);
        System.out.println(staticBean);
        System.out.println(staticBean == StaticBean.factoryMethod());
        System.out.println("测试实例工厂方法实例化类");
        MyBean myBean = context.getBean(MyBean.class);
        System.out.println(myBean);
        context.close();
    }

}
