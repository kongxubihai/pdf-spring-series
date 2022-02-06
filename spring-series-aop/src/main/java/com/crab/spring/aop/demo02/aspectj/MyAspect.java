package com.crab.spring.aop.demo02.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/6 16:13
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Aspect
public class MyAspect {
    @Pointcut("execution(public * com.crab.spring.aop.demo02.aspectj.MyService4.*(..))")
    public void pc() {
    }

    @Before("pc()")
    public void before(JoinPoint jp) {
        System.out.println("前置通知：" + jp);
    }

}
