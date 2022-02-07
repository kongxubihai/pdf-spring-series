package com.crab.spring.aop.demo03.advice;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/7 14:13
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Service3 {
    public void m(){
        throw new IllegalStateException("自定义抛出IllegalStateException");
    }

    public void m2(){
        throw new RuntimeException("自定义抛出RuntimeException");
    }
}
