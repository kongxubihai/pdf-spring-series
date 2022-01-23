package com.crab.spring.ioc.demo13;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/22 20:56
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Configuration
@ComponentScan
public class AppConfig {

    // 测试环境数据源H2
    @Profile("dev")
    @Bean
    public DataSource devDataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setType("H2");
        dataSource.setUrl("jdbc:h2:xxxxxx");
        return dataSource;
    }
    // 生产环境数据源mysql
    @Profile("prod")
    @Bean
    public DataSource prodDataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setType("mysql");
        dataSource.setUrl("jdbc:mysql:xxxxxx");
        return dataSource;
    }

    // default 环境的 HSQL
    @Profile("default")
    @Bean
    public DataSource defaultDataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setType("HSQL");
        dataSource.setUrl("jdbc:HSQL:xxxxxx");
        return dataSource;
    }

}
