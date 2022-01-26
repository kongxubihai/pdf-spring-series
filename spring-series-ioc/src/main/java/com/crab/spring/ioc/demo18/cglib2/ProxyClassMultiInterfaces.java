package com.crab.spring.ioc.demo18.cglib2;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/25 17:25
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class ProxyClassMultiInterfaces {

    interface Repository1 {
        void m1();
    }

    interface Repository2 {
        void m2();
    }

    static class OrderRepository implements Repository1, Repository2 {
        @Override
        public void m1() {

        }

        @Override
        public void m2() {

        }

        public void add() {

        }
    }


    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OrderRepository.class);
        enhancer.setInterfaces(new Class[]{Repository1.class, Repository2.class});
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("执行 " + method);
            return methodProxy.invokeSuper(o, args);
        });
        Object proxy = enhancer.create();
        if (proxy instanceof OrderRepository) {
            OrderRepository repository = (OrderRepository) proxy;
            repository.m1();
            repository.m2();
            repository.add();
        }
        System.out.println("代理对象的类型： " + proxy.getClass());
        System.out.println("代理对象的直接父类： " + proxy.getClass().getSuperclass());
        System.out.println("代理对象的实现的接口： ");
        Arrays.stream(proxy.getClass().getInterfaces()).forEach(System.out::println);
    }
}
