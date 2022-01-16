package com.crab.spring.ioc.demo06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/15 22:53
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
public class Service7 {
    // 指定注入repositoryB
    @Autowired
    @Qualifier("repositoryB")
    private RepositoryBase repository;

    private RepositoryBase repository2;

    // 在构造函数中指定注入repositoryA
    @Autowired
    public Service7(@Qualifier("repositoryA") RepositoryBase repository2) {
        this.repository2 = repository2;
    }

    @Override
    public String toString() {
        return "Service7{" +
                "repository=" + repository +
                ", repository2=" + repository2 +
                '}';
    }
}


