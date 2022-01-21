package com.crab.spring.ioc.demo12;

import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/20 15:26
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Configuration
@ComponentScan
// @PropertySource("classpath:demo12/jdbc.properties")
public class AppConfig2 {
    // 自定义一个 PropertySourcesPlaceholderConfigurer
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer =
                new PropertySourcesPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource("demo12/jdbc.properties"));
        return configurer;

    }

    @Bean
    public static PropertyOverrideConfigurer propertyOverrideConfigurer() {
        PropertyOverrideConfigurer overrideConfigurer = new PropertyOverrideConfigurer();
        overrideConfigurer.setLocation(new ClassPathResource("demo12/jdbc-override.properties"));
        return overrideConfigurer;
    }

}
