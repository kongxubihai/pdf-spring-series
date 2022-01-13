package com.crab.spring.ioc.demo02;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/12 17:09
 */
public class Demo01Test {

    @Test
    public void test_construct() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo02/spring1.xml");
        BeanOne bean1 = context.getBean("bean1", BeanOne.class);
        System.out.println(bean1);

        System.out.println("演示Setter注入");
        BeanThree beanThree = context.getBean(BeanThree.class);
        System.out.println(beanThree);
        context.close();
    }
}
