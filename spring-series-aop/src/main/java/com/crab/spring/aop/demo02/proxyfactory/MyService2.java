package com.crab.spring.aop.demo02.proxyfactory;

import com.crab.spring.aop.demo02.IService;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/6 15:45
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class MyService2 implements IService {
    @Override
    public void hello(String name) {
        System.out.println("MyService2 hello " + name);
    }
}
