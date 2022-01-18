package com.crab.spring.ioc.demo07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/18 9:57
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Configuration
public class AppConfig3 {

    // 指定初始化和销毁回调方法
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Service2 service2() {
        return new Service2();
    }
}
