package com.crab.spring.ioc.demo17;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/24 11:42
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DemoAnnotation {
    String name() default "";
    Class targetClazz();
}
