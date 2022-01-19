package com.crab.spring.ioc.demo11;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/19 13:58
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class BeanTwo implements InitializingBean {
    // 1 实现接口的方式
    // 2 通过xml init-method 配置的方式
    // 3 注解方式
    @PostConstruct
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanTwo InitializingBean afterPropertiesSet");
    }
}
