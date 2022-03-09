package com.crab.spring.ioc.demo21.module5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/3/3 17:37
 */
// 注入是 7 6 5
@Import({MyDeferredImportSelector.class,  MyImportSelector.class, MyConfiguration5.class})
public class MainConfig3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MainConfig3.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        // bean6
        // bean5
        // bean7
    }
}
