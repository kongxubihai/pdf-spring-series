package com.crab.spring.ioc.demo09;

import com.crab.spring.ioc.demo08.MyNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/18 17:42
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Configuration
@ComponentScan(basePackages = "com.crab.spring.ioc.demo09")
public class AppConfig {
}
