package com.crab.spring.ioc.demo06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/14 11:54
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
public class Service5 {
    private RepositoryA repositoryA;

    public RepositoryA getRepositoryA() {
        return repositoryA;
    }
    @Autowired
    public void setRepositoryA(Optional<RepositoryA> repositoryOptional) {
        RepositoryA repositoryA = repositoryOptional.orElseGet(() -> new RepositoryA());
        this.repositoryA = this.repositoryA;
    }
}

