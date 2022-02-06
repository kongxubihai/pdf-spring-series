package com.crab.spring.aop.demo02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/6 17:08
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Aspect
public class UserAspect {

    @Pointcut("execution(public * com.crab.spring.aop.demo02.UserService.*(..))")
    public void pc(){}

    @Before("pc()")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置通知： " + joinPoint);
    }
}
