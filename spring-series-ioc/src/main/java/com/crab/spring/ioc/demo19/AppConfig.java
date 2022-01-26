package com.crab.spring.ioc.demo19;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 13:44
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Configuration
@ComponentScan
@EnableAsync
public class AppConfig {
}
