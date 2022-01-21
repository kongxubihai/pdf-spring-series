package com.crab.spring.ioc.demo12;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/20 11:21
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
@Order(-2)
public class MyBeanPostProcessor2 implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 返回原始bean
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor2 输出：" +  bean + " 名称是： " + beanName);
        return bean;
    }
}
