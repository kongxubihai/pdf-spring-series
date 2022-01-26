package com.crab.spring.ioc.demo18.cglib2;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/25 17:09
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class OrderRepository implements Repository1, Repository2 {
    @Override
    public void m1() {
        System.out.println("OrderRepository m1");
    }

    @Override
    public void m2() {
        System.out.println("OrderRepository m2");
    }

    public void m3() {
        System.out.println("OrderRepository m3");
    }
}
