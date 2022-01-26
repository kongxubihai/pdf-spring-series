package com.crab.spring.ioc.demo16.i18n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 10:26
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        //  设置类路径下的资源文件
        source.setBasenames("demo16/format","demo16/exceptions");
        return source;
    }
}
