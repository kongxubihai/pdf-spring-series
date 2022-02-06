package com.crab.spring.aop.demo03.service.impl;

import com.crab.spring.aop.demo03.entity.Account;
import org.springframework.stereotype.Service;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/4 23:15
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Service
public class AccountService  {
    public void add(Account entity) {
        System.out.println("添加账号");
        System.out.println(entity);
    }

    public int update(Account entity) {
        System.out.println("更新账号");
        System.out.println(entity);
        return 1;
    }

    public int delete(Integer id) {
        System.out.println("删除账号 id:" + id);
        return 1;
    }

    public Account select(Integer id) {
        System.out.println("查询账号 id：" + id);
        Account account = new Account(100, "xx", "oo");
        System.out.println(account);
        return account;
    }
}
