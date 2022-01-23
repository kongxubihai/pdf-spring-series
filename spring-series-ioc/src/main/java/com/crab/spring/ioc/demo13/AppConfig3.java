package com.crab.spring.ioc.demo13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/23 21:10
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Configuration
// 注入配置文件
@PropertySource("classpath:demo13/app.properties")
public class AppConfig3 {

    @Autowired
    private Environment env;

    @Bean
    public TestBean testBean() {
        TestBean testBean = new TestBean();
        testBean.setName(env.getProperty("testBean.name"));
        return testBean;
    }
}
