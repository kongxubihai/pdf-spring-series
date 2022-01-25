package com.crab.spring.ioc.demo17;

import org.springframework.core.annotation.AliasFor;

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
@AnnotationA
public @interface AnnotationB {
    // 注解AnnotationB内部显式别名
    @AliasFor(value = "aliasForName")
    String name() default "";

    int value() default 1;

    // 注解AnnotationB内部显式别名
    @AliasFor(annotation = AnnotationB.class, attribute = "name")
    String aliasForName() default "";

    // 元注解AnnotationA属性name显式别名
    @AliasFor(annotation = AnnotationA.class, value = "name")
    String aliasForAnnotationAName() default "";

    // 元注解AnnotationA属性name显式别名2
    @AliasFor(annotation = AnnotationA.class, value = "name")
    String aliasForAnnotationAName2() default "";

    // 元注解AnnotationA属性value显式别名
    @AliasFor(annotation = AnnotationA.class, value = "value")
    int aliasForAnnotationAValue() default -1;
}
