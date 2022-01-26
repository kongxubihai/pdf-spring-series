package com.crab.spring.ioc.demo18.cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.CallbackHelper;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/25 15:03
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class TestCglib {

    /**
     * 拦截所有方法，同一个拦截器
     */
    @Test
    public void test_intercept_all_in_one() {
        // 1 创建Enhancer对象
        Enhancer enhancer = new Enhancer();

        // 2 设置父类型，即需要给哪个类创建代理类
        enhancer.setSuperclass(OrderRepository.class);

        // 3 设置回调MethodInterceptor
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * 代理对象方法拦截器
             *
             * @param proxy       代理实例
             * @param method      被代理的方法 OrderRepository中的方法
             * @param args        方法参数
             * @param methodProxy 方法代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println(method + " 方法调用开始");
                // MethodProxy#invokeSuper 调用被代理类的方法
                Object result = methodProxy.invokeSuper(proxy, args);
                System.out.println(method + " 方法调用结束");
                return result;
            }
        });

        // 4 获取代理对象
        Object proxy = enhancer.create();
        OrderRepository repository = (OrderRepository) proxy;

        // 5 调用
        repository.add("xxx");
        repository.delete(100L);
        // 注意test的特殊调用
        repository.test();
        System.out.println("输出代理对象的类型： " + proxy.getClass());
    }


    /**
     * 拦截所有方法，不同方法不同拦截器
     */
    @Test
    public void test_intercept_different() {
        // 1 创建Enhancer对象
        Enhancer enhancer = new Enhancer();

        // 2 设置父类型，即需要给哪个类创建代理类
        enhancer.setSuperclass(OrderRepository.class);

        // 3 设置回调MethodInterceptor
        // 拦截add  统计耗时
        MethodInterceptor addInterceptor = (target, method, objects, methodProxy) -> {
            long starTime = System.nanoTime();
            Object result = methodProxy.invokeSuper(target, objects);
            long endTime = System.nanoTime();
            System.out.println(method + " 耗时纳秒:" + (endTime - starTime));
            return result;

        };
        // 拦截其它  前后输出
        MethodInterceptor otherInterceptor = (target, method, objects, methodProxy) -> {
            System.out.println(method + " 方法调用开始");
            Object result = methodProxy.invokeSuper(target, objects);
            System.out.println(method + " 方法调用结束");
            return result;

        };
        // 使用 CallbackHelper类来获取拦截器
        CallbackHelper callbackHelper = new CallbackHelper(OrderRepository.class, null) {
            @Override
            protected Object getCallback(Method method) {
                boolean isAdd = method.getName().startsWith("add");
                return isAdd ? addInterceptor : otherInterceptor ;
            }
        };
        // 指定拦截器的过滤
        enhancer.setCallbackFilter(callbackHelper);
        // 指定所有拦截器
        enhancer.setCallbacks(callbackHelper.getCallbacks());

        // 4 获取代理对象
        OrderRepository repository = (OrderRepository) enhancer.create();

        // 5 调用
        repository.add("xxx");
        repository.delete(100L);
        // 注意test的特殊调用
        repository.test();
    }

}
