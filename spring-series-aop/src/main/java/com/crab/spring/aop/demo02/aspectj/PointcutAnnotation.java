package com.crab.spring.aop.demo02.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.util.ClassUtils;

import java.lang.annotation.*;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/6 21:41
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Aspect
public class PointcutAnnotation {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface MyAnn4 {
    }

    /**
     * 父类 方法上都有@MyAnn4
     */
    static class P1{
        @MyAnn4
        public void m1(){
            System.out.println("P1 m()");
        }
        @MyAnn4
        public void m2(){
            System.out.println("P1 m2()");
        }
    }

    /**
     * 子类
     * 注意重新重写了父类的m1方法但是没有声明注解@Ann4
     * 新增了m3方法带注解@Ann4
     */
    static class C1 extends P1 {
        @Override
        public void m1() {
            System.out.println("C1 m1()");
        }

        @MyAnn4
        public void m3() {
            System.out.println("C1 m3()");
        }
    }

    // 匹配调用的方法上必须有注解
    @Pointcut("@annotation(com.crab.spring.aop.demo02.aspectj.PointcutAnnotation.MyAnn4)")
    public void pc() {
    }

    @Before("pc()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before: " + joinPoint);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        C1 target = new C1();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.setProxyTargetClass(true);
        // 获取C1上所有接口 spring工具类提供的方法
        Class<?>[] allInterfaces = ClassUtils.getAllInterfaces(target);
        // 设置代理接口
        proxyFactory.setInterfaces(allInterfaces);
        // 添加切面
        proxyFactory.addAspect(PointcutAnnotation.class);
        // 获取代理
        C1 proxy = proxyFactory.getProxy();
        // 调用方法
        proxy.m1();
        proxy.m2();
        proxy.m3();

        System.out.println("JDK代理? " + AopUtils.isJdkDynamicProxy(proxy));
        System.out.println("CGLIB代理? " + AopUtils.isCglibProxy(proxy));

        // 目标对象的目标方法上是否直接声明了注解MyAnn4
        System.out.println(target.getClass().getMethod("m1").getDeclaredAnnotation(MyAnn4.class)!=null);
        System.out.println(target.getClass().getMethod("m2").getDeclaredAnnotation(MyAnn4.class)!=null);
        System.out.println(target.getClass().getMethod("m3").getDeclaredAnnotation(MyAnn4.class)!=null);
    }

}
