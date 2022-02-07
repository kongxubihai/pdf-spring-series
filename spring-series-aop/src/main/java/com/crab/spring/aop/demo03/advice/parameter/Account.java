package com.crab.spring.aop.demo03.advice.parameter;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/7 14:58
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Account {
    private String name;
    private String password;

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
