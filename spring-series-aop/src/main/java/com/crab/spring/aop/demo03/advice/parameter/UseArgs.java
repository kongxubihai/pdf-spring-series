package com.crab.spring.aop.demo03.advice.parameter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * 使用args传递参数到通知中
 *
 * @author zfd
 * @version v1.0
 * @date 2022/2/7 14:59
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Aspect
public class UseArgs {
    static class MyAccountService {
        public void validateAccount(Account account) {
            System.out.println("校验Account ：" + account);
        }
    }

    /**
     *
     */
    @Pointcut("execution(* com.crab.spring.aop.demo03.advice.parameter.UseArgs.MyAccountService.*(..))")
    public void pc(){

    }

    /**
     * args表达式不再指定参数类型，而是指定了传递到通知方法中的参数名称，参数类型在通知方法中定义了
     * 此处指定了Account类型参数为account
     * @param account
     */
    @Before("pc() && args(account,..)")
    public void validateAccountBefore(JoinPoint joinPoint, Account account) {
        System.out.println("前置通知，传递的account参数： " + account);
    }

    public static void main(String[] args) {
        MyAccountService target = new MyAccountService();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(UseArgs.class);
        MyAccountService proxy = proxyFactory.getProxy();
        proxy.validateAccount(new Account("xx", "oo"));
    }

}
