package com.crab.spring.ioc.demo08;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * 自定义作用域策略
 * @author zfd
 * @version v1.0
 * @date 2022/1/19 9:32
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class MyMetadataResolver implements ScopeMetadataResolver {
    @Override
    public ScopeMetadata resolveScopeMetadata(BeanDefinition definition) {
        ScopeMetadata metadata = new ScopeMetadata();
        // 指定原型作用域
        metadata.setScopeName(BeanDefinition.SCOPE_PROTOTYPE);
        // 代理模式为接口
        metadata.setScopedProxyMode(ScopedProxyMode.INTERFACES);
        return metadata;
    }
}
