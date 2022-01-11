package com.crab.spring.ioc.demo02;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/10 16:46
 */
public class ExampleBean {
    private final int years;

    private final String ultimateAnswer;

    public ExampleBean(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }
}
