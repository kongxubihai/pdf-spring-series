package com.crab.spring.ioc.demo01;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/13 13:48
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class MyBean {
    private String name;

    public MyBean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
