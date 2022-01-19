package com.crab.spring.ioc.demo08;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/**
 * 自定义的bean名称生成策略
 * @author zfd
 * @version v1.0
 * @date 2022/1/19 9:07
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class MyNameGenerator implements BeanNameGenerator {
    public MyNameGenerator() {
    }

    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        // bean命名统一采用固定前缀+类名
        return "crab$$" + definition.getBeanClassName();
    }
}
