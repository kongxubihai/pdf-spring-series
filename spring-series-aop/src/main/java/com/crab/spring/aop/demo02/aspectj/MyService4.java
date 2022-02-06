package com.crab.spring.aop.demo02.aspectj;

import com.crab.spring.aop.demo02.IService;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/6 16:11
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class MyService4 implements IService {
    @Override
    public void hello(String name) {
        System.out.println("MyService4 hello " + name);
    }
}
