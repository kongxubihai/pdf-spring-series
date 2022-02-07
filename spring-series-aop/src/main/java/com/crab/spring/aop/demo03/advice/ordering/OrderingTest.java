package com.crab.spring.aop.demo03.advice.ordering;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/7 17:24
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class OrderingTest {
    public static void main(String[] args) {
        Service1 target = new Service1();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        // 添加切面
        proxyFactory.addAspect(CommonAspect.class);
        proxyFactory.addAspect(CommonAspect2.class);
        // proxyFactory.addAspect(CommonAspect3.class);
        Service1 proxy = proxyFactory.getProxy();
        // 方法调用
        proxy.hello("xx");
        System.out.println("\n执行异常的结果：");
        proxy.throwException();
    }
}
