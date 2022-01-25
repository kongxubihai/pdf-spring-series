package com.crab.spring.ioc.demo17;

import java.lang.annotation.ElementType;
import java.util.Map;

/**
 * 综合案例
 * @author zfd
 * @version v1.0
 * @date 2022/1/24 13:31
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@StrongAnnotation(value = "用在类上", elementType = ElementType.TYPE)
public class UseStrongAnnotation<@StrongAnnotation(value = "用在类型参数上T0", elementType = ElementType.TYPE_PARAMETER) T0,
        @StrongAnnotation(value = "用在类型名称上T1", elementType = ElementType.TYPE_USE) T1> {
    @StrongAnnotation(value = "用在字段上", elementType = ElementType.FIELD)
    private String field;

    @StrongAnnotation(value = "构造方法上", elementType = ElementType.CONSTRUCTOR)
    public UseStrongAnnotation(@StrongAnnotation(value = "用在方法参数上", elementType = ElementType.PARAMETER) String field) {
        this.field = field;
    }

    @StrongAnnotation(value = "用在普通方法上", elementType = ElementType.METHOD)
    public void m(@StrongAnnotation(value = "方法参数上", elementType = ElementType.PARAMETER) String name) {
        @StrongAnnotation(value = "用在本地变量上", elementType = ElementType.LOCAL_VARIABLE)
        String prefix = "hello ";
        System.out.println(prefix + name);
    }

    public <@StrongAnnotation(value = "方法的类型参数T2上", elementType = ElementType.TYPE_PARAMETER) T2> void m1() {

    }
    public <@StrongAnnotation(value = "方法的类型名称T3上", elementType = ElementType.TYPE_USE) T3> void m2() {

    }

    private Map<@StrongAnnotation(value = "Map后面的尖括号也是类型名称", elementType = ElementType.TYPE_USE) String ,
    @StrongAnnotation(value = "Map后面的尖括号也是类型名称", elementType = ElementType.TYPE_PARAMETER)Object> map;
}
