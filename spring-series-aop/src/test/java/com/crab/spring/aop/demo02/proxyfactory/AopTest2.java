package com.crab.spring.aop.demo02.proxyfactory;

import com.crab.spring.aop.demo02.IService;
import org.junit.Test;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/6 15:46
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class AopTest2 {

    /**
     * 1 ProxyFactory 简化代理创建
     */
    @Test
    public void test01() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new MyService());
        proxyFactory.addAdvisor(new DefaultPointcutAdvisor(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("前置通知，执行方法： " + method.getName());
            }
        }));
        Object proxy = proxyFactory.getProxy();
        System.out.println("代理对象的类型：" + proxy.getClass());
        System.out.println("代理对象父类：" + proxy.getClass().getSuperclass());
        System.out.println("实现的接口： ");
        for (Class<?> cf : proxy.getClass().getInterfaces()) {
            System.out.println(cf);
        }
    }

    /**
     * 2 代理接口
     */
    @Test
    public void test02() {
        ProxyFactory proxyFactory = new ProxyFactory();
        // 代理对象
        proxyFactory.setTarget(new MyService());
        // 代理接口设置
        proxyFactory.addInterface(IService.class);
        // 是否强制使用cglib
        proxyFactory.setProxyTargetClass(false);
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("前置通知，执行方法： " + method.getName());
            }
        });
        IService proxy = (IService) proxyFactory.getProxy();
        System.out.println("代理对象的类型：" + proxy.getClass());
        System.out.println("代理对象父类：" + proxy.getClass().getSuperclass());
        System.out.println("实现的接口： ");
        for (Class<?> cf : proxy.getClass().getInterfaces()) {
            System.out.println(cf);
        }
        // 方法调用
        proxy.hello("xxx");
    }


    @Test
    public void test03() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new MyService3());
        proxyFactory.addAdvisor(new DefaultPointcutAdvisor(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("前置通知，执行方法： " + method.getName());
            }
        }));
        // 暴露代理对象到ThreadLocal中
        proxyFactory.setExposeProxy(true);
        MyService3 proxy = (MyService3) proxyFactory.getProxy();
        proxy.m2();
    }
}
