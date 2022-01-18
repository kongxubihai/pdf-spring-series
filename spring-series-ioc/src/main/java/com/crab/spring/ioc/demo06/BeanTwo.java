package com.crab.spring.ioc.demo06;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/18 13:53
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class BeanTwo {
    // 注解注入 BeanOne
    @Autowired
    private BeanOne beanOne;

    @Override
    public String toString() {
        return "BeanTwo{" +
                "beanOne=" + beanOne +
                '}';
    }
}
