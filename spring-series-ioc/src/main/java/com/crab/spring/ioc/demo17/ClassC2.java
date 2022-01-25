package com.crab.spring.ioc.demo17;

import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/25 8:27
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@AnnotationB(value = 100,
        name = "xx",
        aliasForAnnotationAName = "a1",
        aliasForAnnotationAValue = -100
)
public class ClassC2 {
    public static void main(String[] args) {
        //spring提供一个查找注解的工具类AnnotatedElementUtils
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(ClassC2.class, AnnotationB.class));
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(ClassC2.class, AnnotationA.class));
    }
}
