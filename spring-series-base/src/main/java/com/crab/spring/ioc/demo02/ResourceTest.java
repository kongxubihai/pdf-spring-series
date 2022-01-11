package com.crab.spring.ioc.demo02;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/11 18:27
 */
public class ResourceTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring" +
                ".xml");
        MyConfig myConfig = context.getBean(MyConfig.class);
        Resource template = myConfig.getTemplate();
        System.out.println(template);
        System.out.println(template instanceof  ClassPathResource);
    }
}
