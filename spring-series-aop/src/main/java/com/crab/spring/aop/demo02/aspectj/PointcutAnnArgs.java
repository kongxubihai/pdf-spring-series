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
public class PointcutAnnArgs {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Inherited // 子类能继承父类的注解
    @interface MyAnn3 {
    }

    @MyAnn3
    static class MyParameter{

    }

    static class C1  {
        public void m(MyParameter myParameter) {
            System.out.println(myParameter.getClass().getAnnotation(MyAnn3.class));
            System.out.println("C1 m()");
        }
    }

    // 匹配方法上最后的一个参数类型上有注解MyAnn3
    @Pointcut("@args(..,com.crab.spring.aop.demo02.aspectj.PointcutAnnArgs.MyAnn3)")
    public void pc() {
    }

    @Before("pc()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before: " + joinPoint);
    }

    public static void main(String[] args) {
        C1 target = new C1();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.setProxyTargetClass(true);
        // 获取C1上所有接口 spring工具类提供的方法
        Class<?>[] allInterfaces = ClassUtils.getAllInterfaces(target);
        // 设置代理接口
        proxyFactory.setInterfaces(allInterfaces);
        // 添加切面
        proxyFactory.addAspect(PointcutAnnArgs.class);
        // 获取代理
        C1 proxy = proxyFactory.getProxy();
        // 调用方法
        MyParameter myParameter = new MyParameter();
        proxy.m(myParameter);
        System.out.println("JDK代理? " + AopUtils.isJdkDynamicProxy(proxy));
        System.out.println("CGLIB代理? " + AopUtils.isCglibProxy(proxy));
        // 目标类上是否有切点注解
        System.out.println(myParameter.getClass().getAnnotation(MyAnn3.class)!= null);
    }

}
