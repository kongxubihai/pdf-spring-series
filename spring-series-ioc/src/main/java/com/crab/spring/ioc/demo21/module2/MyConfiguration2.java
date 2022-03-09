package com.crab.spring.ioc.demo21.module2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/3/3 17:00
 */
@Configuration
public class MyConfiguration2 {
    @Bean("com.crab.ioc.demo21.module2.service2")
    public Service2 service2() {
        return new Service2();
    }

    @Bean("com.crab.ioc.demo21.module2.service22")
    public Service2 service22() {
        return new Service2();
    }
}
