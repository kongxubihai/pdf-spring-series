package com.crab.spring.aop.demo04.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;

/**
 * 场景说明：
 * 业务服务的执行有时会由于并发性问题而失败(如抢不到锁)。
 * 如果重试操作，下一次尝试很可能会成功。
 * 对于适合在这种情况下重试的业务服务(不需要返回给用户进行冲突解决的幂等操作)，
 * 我们希望透明地重试操作，以避免客户端看到一个 PessimisticLockingFailureException 异常。
 * 这是一个明显跨越服务层中的多个服务的需求，因此非常适合通过一个切面来实现。
 * 因为我们要重试操作，所以我们需要使用around通知，这样我们就可以多次调用proceed。
 *
 * @author zfd
 * @version v1.0
 * @date 2022/2/10 8:42
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class ConcurrentOperationExecutor implements Ordered {
    private static final int DEFAULT_MAX_RETRIES = 2;

    private int maxRetries = DEFAULT_MAX_RETRIES;
    private int order = 1;


    public Object doConcurrentOperation(ProceedingJoinPoint pjg) throws Throwable {
        int numAttempts = 0;
        PessimisticLockingFailureException lockingFailureException;
        // 循环尝试直到最大次数
        do {
            numAttempts++;
            try {
                return pjg.proceed();
            } catch (PessimisticLockingFailureException ex) {
                lockingFailureException = ex;
            }

        } while (numAttempts <= maxRetries);
        // 尝试结束 抛出异常
        throw lockingFailureException;
    }

    public int getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return this.order;
    }
}
