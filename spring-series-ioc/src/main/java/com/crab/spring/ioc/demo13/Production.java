package com.crab.spring.ioc.demo13;

import org.springframework.context.annotation.Profile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/22 21:38
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Profile("production")
public @interface Production {
}
