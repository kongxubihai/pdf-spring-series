package com.crab.spring.ioc.demo04;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/13 17:00
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class MyBeanA {
    public void init() {
        System.out.println("MyBeanA 被初始化-----");
    }
    public void destroy() {
        System.out.println("MyBeanA 被销毁-----");
    }
}
