package com.crab.spring.aop.demo02.proxyfactory;

import org.springframework.aop.framework.AopContext;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/6 15:45
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class MyService3 {
    public void m(){
        System.out.println("MyService m");
    }

    // m2 中调用m() 测试 setExposeProxy()
    public void m2() {
//        this.m();
        // 代理方法的写法
        ((MyService3)AopContext.currentProxy()).m();
        System.out.println("MyService m2");
    }

}
