package com.crab.spring.aop.demo03.service;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/4 23:10
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public interface IService<T> {
    void add(T entity);

    int update(T entity);

    int delete(Integer id);

    T select(Integer id);
}
