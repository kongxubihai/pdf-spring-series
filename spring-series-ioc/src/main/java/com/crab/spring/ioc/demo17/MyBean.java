package com.crab.spring.ioc.demo17;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/24 11:48
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class MyBean {
    @DemoAnnotation(name = "xxx", targetClazz = MyBean.class)
    public void m() {

    }
}
