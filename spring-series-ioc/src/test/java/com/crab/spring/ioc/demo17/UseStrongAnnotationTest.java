package com.crab.spring.ioc.demo17;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/24 13:52
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class UseStrongAnnotationTest {
    @Test
    public void test_annotated_class() {
        System.out.println("解析类上注解：");
        Arrays.stream(UseStrongAnnotation.class.getAnnotations())
                .forEach(System.out::println);
    }
    // 解析类上注解：
    // @com.crab.spring.ioc.demo17.StrongAnnotation(value=用在类上, elementType=TYPE)

    @Test
    public void test_annotated_class_type_parameter() {
        TypeVariable<Class<UseStrongAnnotation>>[] typeParameters = UseStrongAnnotation.class.getTypeParameters();
        for (TypeVariable<Class<UseStrongAnnotation>> typeParameter : typeParameters) {
            System.out.println(typeParameter.getName() + " 1.8变量参数或变量名称注解信息：");
            Annotation[] annotations = typeParameter.getAnnotations();
            Arrays.stream(annotations).forEach(System.out::println);
        }
    }
    // T0 1.8变量参数或变量名称注解信息：
    // @com.crab.spring.ioc.demo17.StrongAnnotation(value=用在类型参数上T0, elementType=TYPE_PARAMETER)
    // T1 1.8变量参数或变量名称注解信息：
    // @com.crab.spring.ioc.demo17.StrongAnnotation(value=用在类型名称上T1, elementType=TYPE_USE)

    @Test
    public void test_annotated_field() throws NoSuchFieldException {
        Field field = UseStrongAnnotation.class.getDeclaredField("field");
        Arrays.stream(field.getAnnotations()).forEach(System.out::println);
    }
    // @com.crab.spring.ioc.demo17.StrongAnnotation(value=用在字段上, elementType=FIELD)


    @Test
    public void test_annotated_constructor() {
        Constructor<?> constructor = UseStrongAnnotation.class.getDeclaredConstructors()[0];
        for (Annotation annotation : constructor.getAnnotations()) {
            System.out.println(annotation);
        }
    }
    // @com.crab.spring.ioc.demo17.StrongAnnotation(value=构造方法上, elementType=CONSTRUCTO

    @Test
    public void test_annotated_normal_method() throws NoSuchMethodException {
        Method method = UseStrongAnnotation.class.getDeclaredMethod("m", String.class);
        System.out.println("方法注解：");
        for (Annotation annotation : method.getAnnotations()) {
            System.out.println(annotation);
        }
        System.out.println("方法参数注解：");
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter.getName() + " 参数注解：");
            for (Annotation annotation : parameter.getAnnotations()) {
                System.out.println(annotation);
            }
        }
    }
    // 方法注解：
    // @com.crab.spring.ioc.demo17.StrongAnnotation(value=用在普通方法上, elementType=METHOD)
    // 方法参数注解：
    // name 参数注解：
    // @com.crab.spring.ioc.demo17.StrongAnnotation(value=方法参数上, elementType=PARAMETER)

    @Test
    public void test_annotated_map_type() throws NoSuchFieldException {
        Field field = UseStrongAnnotation.class.getDeclaredField("map");
        // 返回一个 Type 对象，该对象表示此 Field 对象表示的字段的声明类型。
        // 如果 Type 是参数化类型，则返回的 Type 对象必须准确反映源代码中使用的实际类型参数。
        Type genericType = field.getGenericType();
        // 获取返回表示此类型的实际类型参数的 Type 对象数组
        Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();

        // 返回一个 AnnotatedType 对象，该对象表示使用一个类型来指定此 Field 表示的字段的声明类型。
        AnnotatedType annotatedType = field.getAnnotatedType();
        // 获取此参数化类型的可能带注释的实际类型参数数组
        AnnotatedType[] annotatedActualTypeArguments =
                ((AnnotatedParameterizedType) annotatedType).getAnnotatedActualTypeArguments();
        int index = 0;
        for (AnnotatedType annotatedActualTypeArgument : annotatedActualTypeArguments) {
            Type actualTypeArgument = actualTypeArguments[index++];
            System.out.println(annotatedActualTypeArgument.getType());
            System.out.println(actualTypeArgument.getTypeName() + " 类型上的注解：");
            for (Annotation annotation : annotatedActualTypeArgument.getAnnotations()) {
                System.out.println(annotation);
            }
        }

    }
    // T0 1.8变量参数或变量名称注解信息：
    // @com.crab.spring.ioc.demo17.StrongAnnotation(value=用在类型参数上T0, elementType=TYPE_PARAMETER)
    // T1 1.8变量参数或变量名称注解信息：
    // @com.crab.spring.ioc.demo17.StrongAnnotation(value=用在类型名称上T1, elementType=TYPE_USE)


}
