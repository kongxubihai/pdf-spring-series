package com.crab.spring.aop.demo03.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/7 11:56
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Aspect
public class AroundAdvice {
    static class MyService {
        public String getVal(String name) {
            System.out.println("MyService getVal");
            return UUID.randomUUID().toString();
        }

    }


    /**
     *
     */
    @Pointcut("execution(* com.crab.spring.aop.demo03.advice.AroundAdvice.MyService.*(..))")
    public void pc() {

    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("统计耗时开始");
        long start = System.nanoTime(); //统计耗时开始
        Object retVal = joinPoint.proceed();
        long end = System.nanoTime();
        System.out.println("统计耗时结束");
        System.out.println("方法执行耗时纳秒：" + (end - start));
        return retVal;
    }

    public static void main(String[] args) {
        MyService target = new MyService();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AroundAdvice.class);

        MyService service2 = proxyFactory.getProxy();

        service2.getVal("xx");
    }

}
