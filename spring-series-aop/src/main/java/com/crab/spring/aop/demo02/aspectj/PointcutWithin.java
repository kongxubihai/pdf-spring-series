package com.crab.spring.aop.demo02.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/6 21:28
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Aspect
public class PointcutWithin {
    // 匹配 com.crab.spring.aop.demo02包及其子包下任何类的任何方法
    @Pointcut("within(com.crab.spring.aop.demo02..*)")
    public void m() {
    }

    // 匹配m.crab.spring.aop.demo02包及其子包下IService类型及其子类型的任何方法
    @Pointcut("within(com.crab.spring.aop.demo02..IService+)")
    public void m2() {
    }

    // 匹配com.crab.spring.aop.demo02.UserService类中所有方法，不含其子类
    @Pointcut("within(com.crab.spring.aop.demo02.UserService)")
    public void m3() {
    }
}
