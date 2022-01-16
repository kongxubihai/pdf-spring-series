package com.crab.spring.ioc.demo06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/14 11:54
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
public class Service6 {
    private RepositoryA repositoryA;

    @Autowired
    public void setRepositoryA(@Nullable RepositoryA repositoryA) {
        this.repositoryA = this.repositoryA;
    }
}

