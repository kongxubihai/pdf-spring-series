package com.crab.spring.aop.demo02;

import org.junit.Test;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Method;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/6 16:45
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class AopCreateTest1 {
    /**
     * 方式1
     * 使用 AdvisedSupport + AopProxyFactory
     */
    @Test
    public void test1() {
        // 1、目标对象
        UserService target = new UserService();
        // 2 代理配置信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTarget(target); // 目标对象
        advisedSupport.addInterface(IService.class);// 代理的接口
        advisedSupport.setProxyTargetClass(true);// 、强制cglib代理
        advisedSupport.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("前置通知，开始执行方法： " + method.getName());
            }
        });

        // 3 创建代理对象的工厂
        DefaultAopProxyFactory proxyFactory = new DefaultAopProxyFactory();
        AopProxy aopProxy = proxyFactory.createAopProxy(advisedSupport);

        // 4 获取代理对象
        Object proxy = aopProxy.getProxy();

        // 5 查看代理的信息
        System.out.println("代理对象的类型："+proxy.getClass());
        System.out.println("代理对象的父类："+proxy.getClass().getSuperclass());
        System.out.println("代理对象实现的接口如下：");
        for (Class<?> itf : proxy.getClass().getInterfaces()) {
            System.out.println(itf);
        }

    }

    /**
     * 方式2
     * 使用 ProxyFactory 简化， ProxyFactory中组合了AopProxyFactory
     */
    @Test
    public void test2() {
        // 1、目标对象
        UserService target = new UserService();
        // 2 创建代理对象的工厂，同时代理配置信息
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);// 目标对象
        proxyFactory.addInterface(IService.class);// 实现接口
        // 添加通知
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("前置通知，开始执行方法： " + method.getName());
            }
        });
        // 3 获取代理对象
        Object proxy = proxyFactory.getProxy();

        // 5 调用方法
        IService service = (IService) proxy;
        service.hello("xx");
    }

    /**
     * 方式3 使用AspectProxyFactory结合@Aspect切面方式
     */
    @Test
    public void test3(){
        // 1、目标对象
        UserService target = new UserService();
        // 2 创建代理对象的工厂，同时代理配置信息
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.setInterfaces(IService.class);
        // 设置切面 含通知和切点
        proxyFactory.addAspect(UserAspect.class);

        // 3 创建代理对象
        IService proxy = proxyFactory.getProxy();

        // 4 执行目标方法
        proxy.hello("xx");
    }

    /**
     * 方式4 使用ProxyFactoryBean
     */
    @Test
    public void test04() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AopProxyFactoryBeanConfig.class);

        // 面向接口，支持Jdk或是CGLIB
        IService userService = (IService) context.getBean("userServiceProxy");

        // 面向类，只支持CGLIB,  proxyFactoryBean.setProxyTargetClass(true)
//        UserService userService = context.getBean("userServiceProxy", UserService.class);
        userService.hello("xxxx");

    }
}
