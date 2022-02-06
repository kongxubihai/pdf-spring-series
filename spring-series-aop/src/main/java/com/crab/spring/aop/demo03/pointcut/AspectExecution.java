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
@Order(1)
public class AspectExecution {
    @Pointcut("execution(* com.crab.spring.aop.demo02.service.impl.*.*(..))")
    private void execution1() {
    }

    @Before("execution1()")
    public void before(JoinPoint jp) {
        MethodSignature signature = (MethodSignature) jp.getSignature();
        System.out.println("切点 execution  前置通知，开始执行方法： " + signature.getMethod().getName());
    }
}
