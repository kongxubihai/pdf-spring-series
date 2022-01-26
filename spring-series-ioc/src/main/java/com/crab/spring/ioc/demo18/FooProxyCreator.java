package com.crab.spring.ioc.demo18;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/25 11:04
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class FooProxyCreator {
    public static void main(String[] args) {
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("invocationHandler 当前调用方式是： " + method.getName());
                return null;
            }
        };
        Object proxyInstance = Proxy.newProxyInstance(Foo.class.getClassLoader(), new Class[]{Foo.class
        }, invocationHandler);
        Foo foo = (Foo) proxyInstance;
        foo.hello("xxx");
        System.out.println("输出代理对象的类型：" + proxyInstance.getClass());
    }
}
