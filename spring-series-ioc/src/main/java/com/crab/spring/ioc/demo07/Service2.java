package com.crab.spring.ioc.demo07;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/18 9:56
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Service2 {

    public void init() {
        System.out.println("Service2 初始化");
    }

    public void destroy() {
        System.out.println("Service2 销毁");
    }
}
