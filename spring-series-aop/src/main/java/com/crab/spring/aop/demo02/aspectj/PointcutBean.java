package com.crab.spring.aop.demo02.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/6 21:41
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Aspect
public class PointcutBean {
    // 容器中bean名称是"myBean1"的方法进行拦截
    @Pointcut("bean(myBean1)")
    public void pc() {
    }

    @Before("pc()")
    public void m(JoinPoint joinPoint) {
        System.out.println("start " + joinPoint);
    }
}
