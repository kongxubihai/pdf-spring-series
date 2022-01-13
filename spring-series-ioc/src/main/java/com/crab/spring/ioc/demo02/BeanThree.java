package com.crab.spring.ioc.demo02;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/13 8:18
 */
public class BeanThree {

    private String name;
    private BeanTwo beanTwo;
    private BeanOne beanOne;

    public void setName(String name) {
        this.name = name;
    }

    public void setBeanTwo(BeanTwo beanTwo) {
        this.beanTwo = beanTwo;
    }

    public void setBeanOne(BeanOne beanOne) {
        this.beanOne = beanOne;
    }

    @Override
    public String toString() {
        return "BeanThree{" +
                "name='" + name + '\'' +
                ", beanTwo=" + beanTwo +
                ", beanOne=" + beanOne +
                '}';
    }
}
