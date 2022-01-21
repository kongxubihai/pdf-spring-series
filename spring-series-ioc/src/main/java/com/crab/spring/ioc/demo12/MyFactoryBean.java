package com.crab.spring.ioc.demo12;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/20 16:44
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component("myFactoryBean")
public class MyFactoryBean implements FactoryBean<BeanOne> {

    @Override
    public BeanOne getObject() throws Exception {
        // 每次生成一个
        return new BeanOne();
    }

    @Override
    public Class<?> getObjectType() {
        return BeanOne.class;
    }

    @Override
    public boolean isSingleton() {
        // 非单例 每次生成一个
        return false;
    }
}
