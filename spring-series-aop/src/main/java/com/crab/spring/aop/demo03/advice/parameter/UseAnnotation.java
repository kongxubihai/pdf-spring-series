package com.crab.spring.aop.demo03.advice.parameter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用@annotation传递参数到通知中
 *
 * @author zfd
 * @version v1.0
 * @date 2022/2/7 14:59
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Aspect
public class UseAnnotation {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Auditable {
        int value();
    }

    static class MyAccountService {
        @Auditable(100)
        public void validateAccount(Account account) {
            System.out.println("校验Account ：" + account);
        }
    }

    /**
     *
     */
    @Pointcut("execution(* com.crab.spring.aop.demo03.advice.parameter.UseAnnotation.MyAccountService.*(..))")
    public void pc() {

    }

    /**
     * @annotation表达式不再指定目标方法包含的注解类型，而是指定了传递到通知方法中的参数名称，参数类型在通知方法中定义了
     * 此处指定了auditable参数，类型是注解 Auditable
     *
     * @param auditable
     */
    @Before("pc() && @annotation(auditable)")
    public void validateAccountBefore(JoinPoint joinPoint, Auditable auditable) {
        System.out.println("前置通知，@annotation传递的auditable参数： " + auditable);
    }

    public static void main(String[] args) {
        MyAccountService target = new MyAccountService();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(UseAnnotation.class);
        MyAccountService proxy = proxyFactory.getProxy();
        proxy.validateAccount(new Account("xx", "oo"));
    }

}
