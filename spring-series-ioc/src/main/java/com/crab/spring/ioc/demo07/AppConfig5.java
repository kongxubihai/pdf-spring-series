package com.crab.spring.ioc.demo07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/18 10:29
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Configuration
// @Component
public class AppConfig5 {

    // 疑问： 此方法被调用了2次，是执行了2次返回了2个RepositoryA？还是只执行一次返回同一个RepositoryA？
    @Bean
    public RepositoryA repositoryA() {
        System.out.println("new 一个 RepositoryA");
        return new RepositoryA();
    }


    @Bean
    public Service5 service5() {
        Service5 service5 = new Service5();
        service5.setRepositoryA(repositoryA());
        return service5;
    }

    @Bean
    public Service6 service6() {
        Service6 service6 = new Service6();
        service6.setRepositoryA(repositoryA());
        return service6;
    }
}
