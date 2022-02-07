package com.crab.spring.aop.demo03.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
public class AfterReturningAdvice {
    /**
     *
     */
    @Pointcut("execution(* com.crab.spring.aop.demo03.advice.Service2.*(..))")
    public void pc(){

    }

    /**
     * 返回通知通过获取returning返回值名称，
     * 注意方法中的第二个参数的类型，仅返回指定类型的值的方法才会增强
     */
    @AfterReturning(pointcut = "pc()", returning = "retVal")
    public void afterReturning1(JoinPoint joinpoint, Object retVal) {
        System.out.println("AfterReturning  返回 Object ：  " + retVal);
    }

    /**
     * 返回通知通过获取returning返回值名称，
     * 注意方法中的第二个参数的类型，仅返回指定类型String的值的方法才会增强
     */
    @AfterReturning(pointcut = "pc()", returning = "retVal")
    public void afterReturning1(JoinPoint joinpoint, String retVal) {
        System.out.println("AfterReturning  返回 String :" + retVal);
    }

    public static void main(String[] args) {
        Service2 target = new Service2();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AfterReturningAdvice.class);

        Service2 service2 = proxyFactory.getProxy();

        service2.getString();
        service2.getLong();
        service2.m();
    }

}
