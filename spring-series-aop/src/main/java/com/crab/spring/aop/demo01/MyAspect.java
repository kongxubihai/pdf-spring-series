package com.crab.spring.aop.demo01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 切面定义
 * 包含切点 通知 引入等
 *
 * @author zfd
 * @version v1.0
 * @date 2022/1/29 13:33
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
@Aspect() // 切面
public class MyAspect {

    /**
     * 声明切入点  这里表达式指：拦截UserService类所有方法执行
     */
    @Pointcut("execution(* com.crab.spring.aop.demo01.UserService.*(..))")
    public void pc(){}

    /**
     * 前置通知，指定切入点
     * @param joinPoint
     */
    @Before("pc()")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("我是前置通知!开始执行方法：" + signature.getMethod().getName());
    }
}
