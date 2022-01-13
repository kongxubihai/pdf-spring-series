package com.crab.spring.ioc.demo01;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/13 13:48
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class MyBeanFactory {

    /**
     * 生成一个 MyBean
     * @return
     */
    public MyBean factoryMethod() {
        return new MyBean("xxx");
    }
}
