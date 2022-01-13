package com.crab.spring.ioc.demo03;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/13 16:29
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class NestedBean {
    private SimpleBean simpleBean;

    public SimpleBean getSimpleBean() {
        return simpleBean;
    }

    public void setSimpleBean(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }
}
