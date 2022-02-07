package com.crab.spring.aop.demo03.advice.parameter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 使用args传递泛型参数到通知中
 *
 * @author zfd
 * @version v1.0
 * @date 2022/2/7 14:59
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Aspect
public class UseArgsGeneric {

    static class MyAccountService implements Sample<Account> {
        public void validateAccount(Account account) {
            System.out.println("校验Account ：" + account);
        }

        @Override
        public void sampleGenericMethod(Account param) {
            System.out.println("MyAccountService sampleGenericMethod :" + param);
        }

        @Override
        public void sampleGenericCollectionMethod(Collection<Account> params) {
            System.out.println("sampleGenericCollectionMethod: ");
        }
    }

    /**
     * 匹配 Sample接口及其子类的sampleGenericMethod方法执行
     */
    @Pointcut("execution(* com.crab.spring.aop.demo03.advice.parameter.Sample+.sampleGenericMethod(..))")
    public void pc() {

    }

    /**
     * 匹配 Sample接口及其子类的 sampleGenericCollectionMethod 方法执行
     */
    @Pointcut("execution(* com.crab.spring.aop.demo03.advice.parameter.Sample+.sampleGenericCollectionMethod(..))")
    public void pc2() {

    }

    /**
     * args 传递泛型参数，参数类型指定具体的类型Account
     *
     *
     * @param account
     */
    @Before("pc() && args(account,..)")
    public void before1(JoinPoint joinPoint, Account account) {
        System.out.println("前置通知，传递的account参数： " + account);
    }

    /**
     * args 传递泛型参数，参数类型指定具体的类型String
     *
     * @param account
     */
    @Before("pc() && args(account,..)")
    public void before2(JoinPoint joinPoint, String account) {
        System.out.println("前置通知，传递的account参数： " + account);
    }


    /**
     * 泛型集合无效
     * @param col
     */
    @Before("pc() && args(col,..)")
    public void before3(JoinPoint joinPoint, Collection<?> col) {
        System.out.println("前置通知，传递的集合参数： " + col);
    }

    public static void main(String[] args) {
        MyAccountService target = new MyAccountService();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(UseArgsGeneric.class);
        MyAccountService proxy = proxyFactory.getProxy();
        proxy.sampleGenericMethod(new Account("xx", "oo"));
        // before1将拦截

        // 观察下集合形式
        List<Account> accountList = Arrays.asList(new Account("xx1", "00x"), new Account("00", "xx"), null);
        proxy.sampleGenericCollectionMethod(accountList);
    }

}
