package com.crab.spring.ioc.demo03;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/13 15:07
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class SimpleBean {
    private String name;
    private int age;
    private float height;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

}
