package com.crab.spring.ioc.demo07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/16 16:07
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Configuration
public class AppConfig {

    @Bean
    public RepositoryBase repositoryBase() {
        return new RepositoryA();
    }
}
