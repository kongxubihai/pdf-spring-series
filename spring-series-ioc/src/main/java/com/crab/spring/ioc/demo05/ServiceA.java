package com.crab.spring.ioc.demo05;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/14 11:54
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class ServiceA {
    private RepositoryA repositoryA;
    private RepositoryB repositoryB;

    public void setRepositoryA(RepositoryA repositoryA) {
        this.repositoryA = repositoryA;
    }

    public void setRepositoryB(RepositoryB repositoryB) {
        this.repositoryB = repositoryB;
    }

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
