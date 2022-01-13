package com.crab.spring.ioc.demo01;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/13 13:38
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class StaticBean {

    private static StaticBean instance = new StaticBean();

    private StaticBean() {
    }

    /**
     * 静态工厂方法返回实例
     *
     * @return
     */
    public static StaticBean factoryMethod() {
        return instance;
    }

}
