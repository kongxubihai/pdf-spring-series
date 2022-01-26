package com.crab.spring.ioc.demo18;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/25 14:20
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class TimeCostMonitorTest {

    @Test
    public void createProxy() {
        Repository repository = TimeCostMonitor.createProxy(new OrderRepository(), Repository.class);
        repository.add("xx");
        repository.delete(100L);
    }

}
