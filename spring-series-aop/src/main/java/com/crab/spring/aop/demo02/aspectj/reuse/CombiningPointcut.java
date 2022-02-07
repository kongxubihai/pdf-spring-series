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
public class CombiningPointcut {

    /**
     * 匹配 com.crab.spring.aop.demo02包及子包下任何类的public方法
     */
    @Pointcut("execution(public * com.crab.spring.aop.demo02..*.*(..))")
    public void publicMethodPc() {
    }

    /**
     * com.crab.spring.aop.demo02.UserService类的所有方法
     */
    @Pointcut("execution(* com.crab.spring.aop.demo02.UserService.*(..))")
    private void serviceMethodPc(){}


    /**
     * 组合的切点
     */
    @Pointcut("publicMethodPc() && serviceMethodPc()")
    public void combiningPc(){

    }
    /**
     * 组合的切点2
     */
    @Pointcut("publicMethodPc() || !serviceMethodPc()")
    public void combiningPc2(){

    }

}
