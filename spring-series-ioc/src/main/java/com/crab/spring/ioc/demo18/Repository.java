package com.crab.spring.ioc.demo18;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/25 14:18
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public interface Repository<T> {
    void add(T t);

    int delete(Long id);
}
