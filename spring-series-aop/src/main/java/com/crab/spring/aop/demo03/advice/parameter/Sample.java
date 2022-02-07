package com.crab.spring.aop.demo03.advice.parameter;

import java.util.Collection;

/**
 * 泛型接口
 * @author zfd
 * @version v1.0
 * @date 2022/2/7 15:38
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public interface Sample<T> {
    void sampleGenericMethod(T param);
    void sampleGenericCollectionMethod(Collection<T> params);
}
