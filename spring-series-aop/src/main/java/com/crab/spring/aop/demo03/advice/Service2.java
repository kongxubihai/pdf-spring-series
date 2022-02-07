package com.crab.spring.aop.demo03.advice;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/7 13:31
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Service2 {
    public String getString() {
        System.out.println("Service2 getString");
        return "xxx";
    }

    public Long getLong() {
        System.out.println("Service2 getLong");
        return 100L;
    }

    public void m() {
        System.out.println("Service2 m");
    }
}
