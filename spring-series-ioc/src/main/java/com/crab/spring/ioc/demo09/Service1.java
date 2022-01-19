package com.crab.spring.ioc.demo09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/19 9:59
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
public class Service1 {
    @Resource
    private RepositoryA repositoryA;

    private RepositoryB repositoryB;

    @Resource
    public void setRepositoryB(RepositoryB repositoryB) {
        this.repositoryB = repositoryB;
    }

    @Override
    public String toString() {
        return "Service1{" +
                "repositoryA=" + repositoryA +
                ", repositoryB=" + repositoryB +
                '}';
    }
}
