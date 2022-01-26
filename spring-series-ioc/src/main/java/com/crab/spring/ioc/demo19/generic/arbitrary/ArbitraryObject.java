package com.crab.spring.ioc.demo19.generic.arbitrary;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 16:08
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class ArbitraryObject {
    private String name;

    public ArbitraryObject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ArbitraryObject{" +
                "name='" + name + '\'' +
                '}';
    }
}
