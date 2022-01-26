package com.crab.spring.ioc.demo18.cglib2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/25 17:11
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class OrderRepositoryTest {

    @Test
    public void test() {
        OrderRepository proxy = CglibCommonLogMonitor.createProxy(new OrderRepository(), Repository2.class,
                Repository1.class);

        proxy.m1();
        proxy.m2();
        proxy.m3();
        System.out.println("代理类类型： " + proxy.getClass().getName());
        System.out.println("代理类父类： "+ proxy.getClass().getSuperclass());
        System.out.println("代理类实现的接口： ");
        Class<?>[] interfaces = proxy.getClass().getInterfaces();
        for (Class<?> clazz :interfaces){
            System.out.println(clazz);
        }
    }
}
