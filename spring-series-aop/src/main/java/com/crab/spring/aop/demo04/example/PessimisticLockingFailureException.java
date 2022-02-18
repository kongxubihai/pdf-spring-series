package com.crab.spring.aop.demo04.example;

/**
 * 悲观锁定失败异常
 * @author zfd
 * @version v1.0
 * @date 2022/2/10 8:51
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class PessimisticLockingFailureException extends RuntimeException {
    public PessimisticLockingFailureException(String message) {
        super(message);
    }
}
