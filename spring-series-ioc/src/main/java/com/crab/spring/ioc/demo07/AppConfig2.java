package com.crab.spring.ioc.demo07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/18 9:48
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Configuration
public class AppConfig2 {

    @Bean
    public RepositoryA repositoryA() {
        return new RepositoryA();
    }

    // 1  类似构造函数方式注入依赖 RepositoryA
    @Bean
    public Service1 service1(RepositoryA repositoryA) {
        return new Service1(repositoryA);
    }

    // 2 同一个 @Configuration 可通过方法名直接注入依赖
    @Bean
    public Service1 service2() {
        return new Service1(repositoryA());
    }

}
