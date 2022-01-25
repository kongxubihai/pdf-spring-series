package com.crab.spring.ioc.demo17;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/25 8:25
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationA {
    String name() default "";
    int value() default -1;
}
