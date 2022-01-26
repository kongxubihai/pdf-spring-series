package com.crab.spring.ioc.demo18.cglib;

import com.crab.spring.ioc.demo18.TimeCostMonitor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/25 16:11
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class CglibTimeCostMonitor implements MethodInterceptor {

    private Object target;

    public CglibTimeCostMonitor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        long start = System.nanoTime();
        // 1 原始业务：调用目标方法
        Object result = methodProxy.invokeSuper(target, args);
        long end = System.nanoTime();
        // 2 新增统计耗时业务执行
        System.out.println(target.getClass() + " 方法 " + method.getName() + " 耗时纳秒：" + (end - start));
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
        enhancer.setCallback(new CglibTimeCostMonitor(target));
        T proxy = (T) enhancer.create();
        return proxy;
    }
}
