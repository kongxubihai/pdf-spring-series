package com.crab.spring.ioc.demo03;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/13 15:41
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class MyBean {

    private RefBean refBean;

    public void setRefBean(RefBean refBean) {
        this.refBean = refBean;
    }
}
