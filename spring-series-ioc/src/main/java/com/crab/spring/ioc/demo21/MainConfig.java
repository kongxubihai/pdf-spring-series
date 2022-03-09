package com.crab.spring.ioc.demo21;


import com.crab.spring.ioc.demo21.module1.Service1;
import com.crab.spring.ioc.demo21.module2.MyConfiguration2;
import com.crab.spring.ioc.demo21.module3.MyComponentScan3;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/3/3 17:03
 */
@Import({Service1.class, MyConfiguration2.class, MyComponentScan3.class})
public class MainConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
