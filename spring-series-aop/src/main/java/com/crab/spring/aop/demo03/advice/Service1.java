package com.crab.spring.aop.demo03.advice;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/7 11:31
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Service1 {
    /**
     * 正常执行的方法
     */
    public String hello(String name) {
        System.out.println("hello " + name);
        return "hello " + name + "!";
    }

    /**
     * 执行抛出异常的方法
     */
    public void throwException() {
        System.out.println("throws a runtime exception");
        throw new RuntimeException("方法执行异常了");
    }
}
