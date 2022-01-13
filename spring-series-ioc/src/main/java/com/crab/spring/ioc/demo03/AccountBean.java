package com.crab.spring.ioc.demo03;

import java.util.Map;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/13 16:19
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class AccountBean {
    private Map<String, Float> accounts;

    public void setAccounts(Map<String, Float> accounts) {
        this.accounts = accounts;
    }
}
