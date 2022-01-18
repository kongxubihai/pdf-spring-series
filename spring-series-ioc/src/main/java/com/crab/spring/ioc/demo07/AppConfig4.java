package com.crab.spring.ioc.demo07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/18 10:06
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Configuration
public class AppConfig4 {
    // 有默认的公共的 shutdown 指定为空就不会被调用
    @Bean(initMethod = "")
    public Service4 service4() {
        return new Service4();
    }
}
