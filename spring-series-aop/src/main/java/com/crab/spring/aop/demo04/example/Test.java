package com.crab.spring.aop.demo04.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/10 9:11
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo04/spring.xml");
        ConcurrentService concurrentService = context.getBean(ConcurrentService.class);
        // concurrentService.doConcurrentOperation(100);
        // 执行非幂等操作
        concurrentService.doConcurrentOperationNonIdempotent(100);
        context.close();
    }
}
