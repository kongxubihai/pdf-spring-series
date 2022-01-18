package com.crab.spring.ioc.demo07;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/18 9:48
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Service1 {
    private RepositoryA repositoryA;

    public Service1(RepositoryA repositoryA) {
        this.repositoryA = repositoryA;
    }
}
