package com.crab.spring.aop.demo01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/29 11:57
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy()
public class AppConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.add("xxx");
        context.close();
    }
}
