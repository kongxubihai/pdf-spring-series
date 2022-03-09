package com.crab.spring.ioc.demo21.module6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/3/3 18:03
 */
@Import(MyImportBeanDefinitionRegistrar.class)
public class MainConfig6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MainConfig6.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
