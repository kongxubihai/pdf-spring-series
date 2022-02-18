package com.crab.spring.aop.demo04.example;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/10 8:53
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class ConcurrentService {

    @Idempotent
    public void doConcurrentOperation(Integer id) {
        // 模拟抢锁 失败后抛出 PessimisticLockingFailureException 异常
        System.out.println("幂等操作");
        System.out.println("开始尝试获取锁");
        System.out.println("获取锁失败，抛出失败异常");
        throw new PessimisticLockingFailureException("获取锁失败");
    }

    public void doConcurrentOperationNonIdempotent(Integer id) {
        // 模拟抢锁 失败后抛出 PessimisticLockingFailureException 异常
        System.out.println("非幂等操作");
        System.out.println("开始尝试获取锁");
        System.out.println("获取锁失败，抛出失败异常");
        throw new PessimisticLockingFailureException("获取锁失败");
    }
}
