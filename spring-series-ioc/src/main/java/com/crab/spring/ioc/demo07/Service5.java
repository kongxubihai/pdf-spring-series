package com.crab.spring.ioc.demo07;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/18 10:31
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Service5 {
    private RepositoryA repositoryA;

    public void setRepositoryA(RepositoryA repositoryA) {
        this.repositoryA = repositoryA;
    }

    public RepositoryA getRepositoryA() {
        return repositoryA;
    }
}
