package com.crab.spring.ioc.demo17;

import java.lang.annotation.*;

/**
 * 测试 @Repeatable 注解重复使用
 * @author zfd
 * @version v1.0
 * @date 2022/1/24 17:30
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class TestRepeatable {
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(ComponentScans.class)
    @interface  ComponentScan{}

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface ComponentScans{
        // 注意： 必须定义value参数，其类型是子重复注解的数组类型
        ComponentScan[] value();
    }

    // 重复注解方式1
    @ComponentScan
    @ComponentScan
    static class MyComponent{}

    // 重复注解方式2
    @ComponentScans({@ComponentScan, @ComponentScan})
    static class MyComponentB{}

    public static void main(String[] args) {
        for (Annotation annotation : MyComponent.class.getAnnotations()) {
            System.out.println(annotation);
        }
        for (Annotation annotation : MyComponentB.class.getAnnotations()) {
            System.out.println(annotation);
        }
    }
    // 输出
    // @com.crab.spring.ioc.demo17.TestRepeatable$ComponentScans(value=[@com.crab.spring.ioc.demo17
    // .TestRepeatable$ComponentScan(), @com.crab.spring.ioc.demo17.TestRepeatable$ComponentScan()])
    // @com.crab.spring.ioc.demo17.TestRepeatable$ComponentScans(value=[@com.crab.spring.ioc.demo17
    // .TestRepeatable$ComponentScan(), @com.crab.spring.ioc.demo17.TestRepeatable$ComponentScan()])

}
