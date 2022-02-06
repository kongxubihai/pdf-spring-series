package com.crab.spring.aop.demo02;

import com.crab.spring.aop.demo03.AppConfig;
import com.crab.spring.aop.demo03.entity.Account;
import com.crab.spring.aop.demo03.service.impl.AccountService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/4 23:22
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class IServiceTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        AccountService accountService = context.getBean(AccountService.class);
        Account account = accountService.select(100);
        System.out.println(accountService);
        context.close();
    }
}
