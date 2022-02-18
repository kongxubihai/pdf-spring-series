package com.crab.spring.aop.demo04.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 方法是否是幂等的
 * @author zfd
 * @version v1.0
 * @date 2022/2/10 9:15
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Idempotent {
}
