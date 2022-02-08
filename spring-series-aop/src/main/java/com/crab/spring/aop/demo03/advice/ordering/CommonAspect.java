package com.crab.spring.aop.demo03.advice.ordering;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 同一个切面内不同通知类型的顺序
 * @author zfd
 * @version v1.0
 * @date 2022/2/7 11:34
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Aspect // 切面
@Order(1) // 切面排序 等同
@Component
public class CommonAspect {

    /**
     * 公共切点
     *  匹配Service1的所有方法
     */
    @Pointcut("execution(* com.crab.spring.aop.demo03.advice.ordering.Service1.*(..))")
    public void pc(){

    }

    /**
     * 前置通知
     */
    @Before("pc()")
    public void before(JoinPoint joinpoint){
        System.out.println("Before: " +  joinpoint);
    }

    /**
     * 返回通知
     */
    @AfterReturning("pc()")
    public void afterReturning(JoinPoint joinpoint){
        System.out.println("AfterReturning: " +  joinpoint);
    }

    /**
     * 抛出异常通知
     */
    @AfterThrowing("pc()")
    public void afterThrowing(JoinPoint joinpoint){
        System.out.println("AfterThrowing: " +  joinpoint);
    }

    /**
     * 最终通知
     */
    @After("pc()")
    public void after(JoinPoint joinpoint){
        System.out.println("After: " +  joinpoint);
    }

    /**
     * 最终通知
     */
    @Around("pc()")
    public Object around(ProceedingJoinPoint pdj) throws Throwable {
        System.out.println("Around start: " + pdj);
        Object ret = pdj.proceed();
        System.out.println("Around end: " + pdj);
        return ret;
    }

    public static void main(String[] args) {
        Service1 target = new Service1();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        // 添加切面
        proxyFactory.addAspect(CommonAspect.class);
        Service1 proxy = proxyFactory.getProxy();
        // 方法调用
        proxy.hello("xx");
        System.out.println("\n执行异常的结果：");
        proxy.throwException();
    }
}
