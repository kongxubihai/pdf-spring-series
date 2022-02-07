package com.crab.spring.aop.demo02.aspectj.reuse;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 组合切点
 *
 * @author zfd
 * @version v1.0
 * @date 2022/2/7 8:39
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class CombiningPointcut2 {

    /**
     * com.crab.spring.aop.demo02.UserService类的所有方法
     */
    @Pointcut("execution(* com.crab.spring.aop.demo02.UserService.*(..))")
    public void serviceMethodPc2(){}


    /**
     * 组合的切点,跨类组合
     */
    @Pointcut("com.crab.spring.aop.demo02.aspectj.reuse.CombiningPointcut.publicMethodPc() && serviceMethodPc2()")
    public void combiningPc(){

    }

}
