package com.crab.spring.aop.demo02;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * ProxyFactoryBean 方式创建代理
 * @author zfd
 * @version v1.0
 * @date 2022/2/6 17:20
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Configuration
public class AopProxyFactoryBeanConfig {

    // 1 注册目标对象
    @Bean("userService")
    public UserService userService() {
        return new UserService();
    }

    // 2 注册通知
    @Bean("beforeAdvice")
    public MethodBeforeAdvice beforeAdvice() {
        return new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("前置通知： " + method);
            }
        };
    }

    // 3 注册ProxyFactoryBean
    @Bean("userServiceProxy")
    public ProxyFactoryBean userServiceProxy() {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        // 设置目标对象的bean名称
        proxyFactoryBean.setTargetName("userService");
        // 设置拦截器的bean名称
        proxyFactoryBean.setInterceptorNames("beforeAdvice");
        // 代理方式
//        proxyFactoryBean.setProxyTargetClass(true);
        return proxyFactoryBean;
    }

}
