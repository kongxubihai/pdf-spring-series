package com.crab.spring.ioc.demo18.cglib2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/25 16:11
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class CglibCommonLogMonitor implements MethodInterceptor {

    private Object target;

    public CglibCommonLogMonitor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行开始： " + method.getName());
        Object result = methodProxy.invokeSuper(target, args);
        System.out.println("执行结束： " + method.getName());
        return result;
    }



    /**
     * 创建代理实例
     * @param target 被代理对象，必须非final
     * @param <T>  类型
     * @return 接口实现类实例
     */
    public static <T> T createProxy(T target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new CglibCommonLogMonitor(target));
        T proxy = (T) enhancer.create();
        return proxy;
    }

    /**
     * 创建代理实例
     * @param target 被代理对象，必须非final
     * @param interfaces 指定被代理接口类
     * @param <T>  类型
     * @return 接口实现类实例
     */
    public static <T> T createProxy(T target, Class ...interfaces) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setInterfaces(interfaces);
        enhancer.setCallback(new CglibCommonLogMonitor(target));
        T proxy = (T) enhancer.create();
        return proxy;
    }
}
