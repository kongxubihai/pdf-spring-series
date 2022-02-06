package com.crab.spring.aop.demo03.pointcut;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/4 23:25
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Aspect
@Component
@Order(4         )
public class AspectTarget {
    @Pointcut("target(com.crab.spring.aop.demo03.service.impl.AccountService)")
    private void pc() {
    }

    @Before("pc()")
    public void before(JoinPoint jp) {
        MethodSignature signature = (MethodSignature) jp.getSignature();
        System.out.println("切点类型 target  前置通知，开始执行方法： " + signature.getMethod().getName());
    }
}
