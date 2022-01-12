package com.crab.spring.ioc.demo01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.function.Consumer;

import static org.junit.Assert.*;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/12 17:09
 */
public class Demo01Test {

    @Test
    public void test_construct() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo01/spring1.xml");
        BeanOne bean1 = context.getBean("bean1", BeanOne.class);
        System.out.println(bean1);
        context.close();
    }
}
