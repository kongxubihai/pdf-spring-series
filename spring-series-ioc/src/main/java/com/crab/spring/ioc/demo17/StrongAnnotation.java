package com.crab.spring.ioc.demo17;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用范围广泛的自定义注解
 *
 * @author zfd
 * @version v1.0
 * @date 2022/1/24 11:51
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Target({ElementType.TYPE, // 类、接口、枚举、注解上面
        ElementType.METHOD, // 方法
        ElementType.FIELD,  // 字段
        ElementType.PARAMETER, // 方法参数
        ElementType.CONSTRUCTOR, // 构造方法
        ElementType.LOCAL_VARIABLE, // 本地变量
        ElementType.TYPE_PARAMETER, // 类型参数上 1.8之后 类型参数一般在类后面声明或者方法上声明
        ElementType.TYPE_USE}) // 类型名称上 1.8之后
@Retention(RetentionPolicy.RUNTIME)
public @interface StrongAnnotation {
    String value();

    // 类型
    ElementType elementType();
}
