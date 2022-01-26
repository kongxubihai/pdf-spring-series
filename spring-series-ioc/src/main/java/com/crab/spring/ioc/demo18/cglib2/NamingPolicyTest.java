package com.crab.spring.ioc.demo18.cglib2;

import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 8:28
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class NamingPolicyTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OrderRepository.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("执行 " + method);
            return methodProxy.invokeSuper(o, objects);
        });
        //  设置 NamingPolicy
        enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);

        Object proxy = enhancer.create();
        System.out.println(proxy.getClass());
    }
}
