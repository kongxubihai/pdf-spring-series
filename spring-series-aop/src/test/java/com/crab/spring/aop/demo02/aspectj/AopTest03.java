package com.crab.spring.aop.demo02.aspectj;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import static org.junit.Assert.*;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/6 16:20
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class AopTest03 {

    @Test
    public void test_aspect() {
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        MyService4 target = new MyService4();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(MyAspect.class);

        MyService4 proxy = proxyFactory.getProxy();
        proxy.hello("xxx");
    }

}
