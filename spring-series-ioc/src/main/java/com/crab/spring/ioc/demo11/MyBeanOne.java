package com.crab.spring.ioc.demo11;

import org.springframework.context.Lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/19 14:59
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class MyBeanOne implements Lifecycle {
    @Override
    public void start() {
        System.out.println("Lifecycle start");
    }

    @Override
    public void stop() {
        System.out.println("Lifecycle stop");
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    // 初始化和销毁

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct init");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("@PreDestroy destroy");
    }
}
