package com.crab.spring.ioc.demo07;

import org.springframework.context.annotation.Bean;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/17 9:00
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public interface BaseConfig {
    @Bean
    default RepositoryA repositoryA(){
        return new RepositoryA();
    }
}
