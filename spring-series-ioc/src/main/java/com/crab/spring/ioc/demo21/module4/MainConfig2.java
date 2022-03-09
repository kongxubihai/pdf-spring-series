package com.crab.spring.ioc.demo21.module4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/3/3 17:03
 */
@Import({MyImportSelector.class})
public class MainConfig2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
