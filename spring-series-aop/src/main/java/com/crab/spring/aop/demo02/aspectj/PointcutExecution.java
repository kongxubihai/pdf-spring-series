package com.crab.spring.aop.demo02.aspectj;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/6 21:11
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class PointcutExecution {

    // com.crab.spring.aop.demo02包下任何类的任意方法
    @Pointcut("execution(* com.crab.spring.aop.demo02.*.*(..))")
    public void m1(){}

    // com.crab.spring.aop.demo02包及其子包下任何类的任意方法
    @Pointcut("execution(* com.crab.spring.aop.demo02..*.*(..))")
    public void m2(){}

    // com.crab.spring.aop包及其子包下IService接口的任意无参方法
    @Pointcut("execution(* com.crab.spring.aop..IService.*(..))")
    public void m3(){}

    // com.crab.spring.aop包及其子包下IService接口及其子类型的任意无参方法
    @Pointcut("execution(* com.crab.spring.aop..IService+.*(..))")
    public void m4(){}

    // com.crab.spring.aop.demo02.UserService类中有且只有一个String参数的方法
    @Pointcut("execution(* com.crab.spring.aop.demo02.UserService.*(String))")
    public void m5(){}

    // com.crab.spring.aop.demo02.UserService类中参数个数为2且最后一个参数类型是String的方法
    @Pointcut("execution(* com.crab.spring.aop.demo02.UserService.*(*,String))")
    public void m6(){}

    // com.crab.spring.aop.demo02.UserService类中最后一个参数类型是String的方法
    @Pointcut("execution(* com.crab.spring.aop.demo02.UserService.*(..,String))")
    public void m7(){}
}
