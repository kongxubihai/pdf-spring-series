package com.crab.spring.ioc.demo06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/14 11:54
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
public class ServiceA {
    @Autowired
    private RepositoryA repositoryA;

    @Autowired
    private RepositoryB repositoryB;

    public RepositoryA getRepositoryA() {
        return repositoryA;
    }

    public RepositoryB getRepositoryB() {
        return repositoryB;
    }

    @Override
    public String toString() {
        return "ServiceA{" +
                "repositoryA=" + repositoryA +
                ", repositoryB=" + repositoryB +
                '}';
    }
}
