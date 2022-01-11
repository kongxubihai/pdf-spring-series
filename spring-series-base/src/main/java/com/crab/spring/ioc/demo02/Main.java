package com.crab.spring.ioc.demo02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/10 16:32
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc/demo02/spring1.xml");
        BeanA beanA = context.getBean("beanA", BeanA.class);
        System.out.println(beanA);
        System.out.println(beanA.getB());
        System.out.println(beanA.getC());

        System.out.println("-------------");
        ExampleBean exampleBean = context.getBean(ExampleBean.class);
        System.out.println(exampleBean);
    }
}
