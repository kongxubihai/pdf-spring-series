package com.crab.spring.ioc.demo19.generic;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

/**
 * 泛型的实体创建事件
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 15:09
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class ResolvableEntityCreatedEvent<T> extends ApplicationEvent implements ResolvableTypeProvider {

    public ResolvableEntityCreatedEvent(T source) {
        super(source);
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(getSource()));
    }
}
