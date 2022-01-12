package com.crab.spring.ioc.demo01;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/12 16:59
 */
public class BeanOne {
    private int age;
    private String name;
    private BeanTwo beanTwo;

    /**
     * 构造函数，用于依赖注入，定义3个依赖
     * @param age
     * @param name
     * @param beanTwo
     */
    public BeanOne(int age, String name, BeanTwo beanTwo) {
        this.age = age;
        this.name = name;
        this.beanTwo = beanTwo;
    }

    @Override
    public String toString() {
        return "BeanOne{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", beanTwo=" + beanTwo +
                '}';
    }
}
