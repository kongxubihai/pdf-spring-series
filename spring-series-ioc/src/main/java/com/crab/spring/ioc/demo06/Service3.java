package com.crab.spring.ioc.demo06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/15 17:53
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
public class Service3 {
    @Autowired
    private Map<String, RepositoryBase> repositoryMap;

    public void printMap() {
        this.repositoryMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "--" + entry.getKey());
        });
    }
}
