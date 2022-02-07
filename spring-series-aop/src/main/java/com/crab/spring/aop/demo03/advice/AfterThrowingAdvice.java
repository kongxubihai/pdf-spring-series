package com.crab.spring.aop.demo03.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/7 11:56
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Aspect
public class AfterThrowingAdvice {

    /**
     *
     */
    @Pointcut("execution(* com.crab.spring.aop.demo03.advice.Service3.*(..))")
    public void pc(){

    }

    /**
     * throwing指定异常参数名称
     * 匹配 IllegalStateException
     * @param joinpoint
     * @param ex
     */
    @AfterThrowing(pointcut = "pc()", throwing = "ex")
    public void afterThrowing1(JoinPoint joinpoint, IllegalStateException ex) {
        System.out.println("AfterThrowing  异常类型 ：  " + ex);
    }

    @AfterThrowing(pointcut = "pc()", throwing = "ex")
    public void afterThrowing2(JoinPoint joinpoint, Throwable ex) {
        System.out.println("AfterThrowing  异常类型 ：  " + ex);
    }


    public static void main(String[] args) {
        Service3 target = new Service3();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AfterThrowingAdvice.class);

        Service3 service3 = proxyFactory.getProxy();
        // service3.m();
        service3.m2();
    }

}
