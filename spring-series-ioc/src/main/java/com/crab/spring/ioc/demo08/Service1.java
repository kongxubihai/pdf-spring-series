package com.crab.spring.ioc.demo08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/18 17:41
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
public class Service1 {
    @Autowired
    private RepositoryBase repository;
}
