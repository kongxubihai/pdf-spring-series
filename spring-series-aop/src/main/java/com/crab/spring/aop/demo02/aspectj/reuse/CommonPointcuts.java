package com.crab.spring.aop.demo02.aspectj.reuse;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 公用的切点
 * @author zfd
 * @version v1.0
 * @date 2022/2/7 8:53
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class CommonPointcuts {

    /**
     * web层的通用切点
     */
    @Pointcut("within(com.xyz.myapp.web..*)")
    public void inWebLayer() {}

    @Pointcut("within(com.xyz.myapp.service..*)")
    public void inServiceLayer() {}

    @Pointcut("within(com.xyz.myapp.dao..*)")
    public void inDataAccessLayer() {}

    @Pointcut("execution(* com.xyz.myapp..service.*.*(..))")
    public void businessService() {}

    @Pointcut("execution(* com.xyz.myapp.dao.*.*(..))")
    public void dataAccessOperation() {}
}
