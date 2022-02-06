package com.crab.spring.aop.demo02;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/6 16:44
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class UserService implements IService{
    @Override
    public void hello(String name) {
        System.out.println("hello " + name);
    }
}
