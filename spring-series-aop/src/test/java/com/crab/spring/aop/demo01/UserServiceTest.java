package com.crab.spring.aop.demo01;

import org.junit.Test;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.DefaultAopProxyFactory;

import java.lang.reflect.Method;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/29 16:58
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class UserServiceTest {

    /**
     * 代理对象的创建过程
     * <p>
     * Spring 中代理对象是由AOP工厂类生产的，思考下需要什么？类比下你做西红柿炒鸡蛋
     * 1 得有原材料，西红柿和鸡蛋得提前准备好，得有盐，类比就是为谁代理，代理方式是什么，做哪些增强等，可以归纳为配置
     * 2 然后得有个锅
     * 3 有了材料和锅就可以开炒了，生产出代理对象
     */
    @Test
    public void test_debug_create_proxy() {
        //  1 创建代理需要的配置 AdvisedSupport
        AdvisedSupport advisedSupport = new AdvisedSupport();
        UserService target = new UserService();
        advisedSupport.setTarget(target);
        advisedSupport.setInterfaces(IService.class);
        // 通知增强好比加盐
        advisedSupport.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("开始执行方法： " + method);
            }
        });

        // 2 创建代理生成类 AopProxy
        DefaultAopProxyFactory aopProxyFactory = new DefaultAopProxyFactory();
        AopProxy aopProxy = aopProxyFactory.createAopProxy(advisedSupport);

        // 3 AopProxy 创建代理对象
        Object proxy = aopProxy.getProxy();

        UserService userService = (UserService) proxy;
        userService.add("xx");

    }

}
