package com.crab.spring.ioc.demo20;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/28 15:46
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class MyBean {
    private Double randomNumber;
    private String name;

    public Double getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(Double randomNumber) {
        this.randomNumber = randomNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "randomNumber=" + randomNumber +
                ", name='" + name + '\'' +
                '}';
    }
}
