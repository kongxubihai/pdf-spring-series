package com.crab.spring.ioc.demo21.module5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/3/3 17:31
 */
@Configuration
public class MyConfiguration6 {
    @Bean
    public String bean6() {
        return "bean6";
    }
}
