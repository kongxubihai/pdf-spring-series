package com.crab.spring.ioc.demo18;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 方法耗时监控器
 *
 * @author zfd
 * @version v1.0
 * @date 2022/1/25 11:43
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class TimeCostMonitor implements InvocationHandler {
    private Object target;

    public TimeCostMonitor(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.nanoTime();
        // 1 原始业务：调用目标方法
        Object result = method.invoke(this.target, args);
        long end = System.nanoTime();
        // 2 新增统计耗时业务执行
        System.out.println(this.target.getClass() + " 方法 " + method.getName() + " 耗时纳秒：" + (end - start));
        return result;
    }

    /**
     * 创建代理实例
     * @param target 被代理对象，必须实现被代理接口，否则异常
     * @param targetInterface 被代理接口，必须是接口否则异常
     * @param <T>  接口类型
     * @return 接口实现类实例
     */
    public static <T> T createProxy(Object target, Class<T> targetInterface) {
        if (!targetInterface.isInterface()) {
            throw new IllegalStateException("targetInterface必须是接口类型");
        }
        if (!targetInterface.isAssignableFrom(target.getClass())) {
            throw new IllegalStateException("target必须实现targetInterface接口");
        }
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TimeCostMonitor(target));
    }
}
