package com.crab.spring.aop.demo03.entity;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/4 23:14
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Account {
    private Integer id;
    private String name;
    private String password;

    public Account(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
