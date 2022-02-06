package com.crab.spring.aop.demo02.aspectj;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/6 23:30
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class MyBean {
    private String beanName;

    public MyBean(String beanName) {
        this.beanName = beanName;
    }

    public void m() {
        System.out.println("我是" + this.beanName);
    }
}
