package com.crab.spring.aop.demo02.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.util.ClassUtils;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/6 21:41
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Aspect
public class PointcutTarget {
    interface I1{
        void m();
    }
    static class C1 implements I1{

        @Override
        public void m() {
            System.out.println("C1 m()");
        }
    }

    // 匹配目标类型必须是
    @Pointcut("target(com.crab.spring.aop.demo02.aspectj.PointcutTarget.C1)")
    public void pc(){}

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
        proxyFactory.addAspect(PointcutTarget.class);
        // 获取代理
        I1 proxy = proxyFactory.getProxy();
        // 调用方法
        proxy.m();
        System.out.println("JDK代理? " + AopUtils.isJdkDynamicProxy(proxy));
        System.out.println("CGLIB代理? " + AopUtils.isCglibProxy(proxy));
        //判断代理对象是否是C1类型的
        System.out.println(C1.class.isAssignableFrom(target.getClass()));
    }

}
