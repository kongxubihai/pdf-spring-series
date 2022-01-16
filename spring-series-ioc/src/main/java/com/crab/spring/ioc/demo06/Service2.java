package com.crab.spring.ioc.demo06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/15 17:48
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
public class Service2 {
    @Autowired
    private List<RepositoryBase> repositoryList;
    @Autowired
    private Set<RepositoryBase> repositorySet;
    @Autowired
    private RepositoryBase[] repositoryArr;

    public void setRepositoryList(List<RepositoryBase> repositoryList) {
        this.repositoryList = repositoryList;
    }

    public List<RepositoryBase> getRepositoryList() {
        return repositoryList;
    }

    public Set<RepositoryBase> getRepositorySet() {
        return repositorySet;
    }

    public void setRepositorySet(Set<RepositoryBase> repositorySet) {
        this.repositorySet = repositorySet;
    }

    public RepositoryBase[] getRepositoryArr() {
        return repositoryArr;
    }

    public void setRepositoryArr(RepositoryBase[] repositoryArr) {
        this.repositoryArr = repositoryArr;
    }
}
