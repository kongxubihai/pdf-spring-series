package com.crab.spring.ioc.demo17;

import java.lang.annotation.*;

/**
 * 测试父类注解的继承
 * 注意：是类，不是接口，接口无效
 * @author zfd
 * @version v1.0
 * @date 2022/1/24 17:15
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class TestInherited {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @interface Annotation1{}

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @interface Annotation2{}


    @Annotation1
    interface Interface1{}
    @Annotation2
    static class SupperClass{}

    // 继承 SupperClass 实现 Interface1，观察其注解继承情况
    static class SubClass extends SupperClass implements Interface1{}

    public static void main(String[] args) {
        for (Annotation annotation : SubClass.class.getAnnotations()) {
            System.out.println(annotation);
        }
    }
    // 输出
    // @com.crab.spring.ioc.demo17.TestInherited$Annotation2()
    // 只继承了父类注解 无法继承接口上的注解
}
