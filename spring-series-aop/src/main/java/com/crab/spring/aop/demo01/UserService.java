package com.crab.spring.aop.demo01;

import org.springframework.stereotype.Service;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/29 13:41
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Service
public class UserService implements IService {
    @Override
    public void add(String name) {
        // System.out.println("我是前置通知!开始执行方法：" + "add");
        System.out.println("UserService add " + name);
    }

    @Override
    public void hello(String name) {
        System.out.println("hello " + name);
    }
}
