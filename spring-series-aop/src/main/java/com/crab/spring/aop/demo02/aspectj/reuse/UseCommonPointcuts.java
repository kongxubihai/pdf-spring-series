package com.crab.spring.aop.demo02.aspectj.reuse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 使用公共的切点
 * @author zfd
 * @version v1.0
 * @date 2022/2/7 8:56
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Aspect
public class UseCommonPointcuts {

    /**
     * 直接使用公共切点
     */
    @Before("com.crab.spring.aop.demo02.aspectj.reuse.CommonPointcuts.inWebLayer()")
    public void before(JoinPoint joinPoint){
        System.out.println("before:" + joinPoint);
    }
}
