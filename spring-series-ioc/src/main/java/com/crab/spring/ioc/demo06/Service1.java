package com.crab.spring.ioc.demo06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/15 17:33
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
public class Service1 {
    private RepositoryA repositoryA;
    private RepositoryB repositoryB;
    // 标记field
    @Autowired
    private RepositoryC repositoryC;

    // 标记构造函数
    @Autowired
    public Service1(RepositoryA repositoryA) {
        this.repositoryA = repositoryA;
    }

    @Autowired
    public void setRepositoryB(RepositoryB repositoryB) {
        this.repositoryB = repositoryB;
    }

    @Override
    public String toString() {
        return "Service1{" +
                "repositoryA=" + repositoryA +
                ", repositoryB=" + repositoryB +
                ", repositoryC=" + repositoryC +
                '}';
    }
}
