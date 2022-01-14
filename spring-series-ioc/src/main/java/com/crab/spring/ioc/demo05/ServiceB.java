package com.crab.spring.ioc.demo05;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/14 13:39
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class ServiceB {
    private RepositoryA repositoryA;
    private RepositoryB repositoryB;

    public ServiceB(RepositoryA repositoryA, RepositoryB repositoryB) {
        this.repositoryA = repositoryA;
        this.repositoryB = repositoryB;
    }

    @Override
    public String toString() {
        return "ServiceB{" +
                "repositoryA=" + repositoryA +
                ", repositoryB=" + repositoryB +
                '}';
    }
}
