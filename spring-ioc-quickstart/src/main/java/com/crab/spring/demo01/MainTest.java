package com.crab.spring.demo01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/12 11:56
 */
public class MainTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        A a = context.getBean("a", A.class);
        B b = context.getBean("b", B.class);
        System.out.println("A对象：" + a);
        System.out.println("A对象中的B依赖： " + a.getB() );
        System.out.println("B对象：" + b);
    }
}
