package com.crab.spring.ioc.demo02;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/10 16:29
 */
public class BeanA {
    private BeanB b;
    private BeanC c;

    public BeanA(BeanB b, BeanC c) {
        this.b = b;
        this.c = c;
    }

    public BeanB getB() {
        return b;
    }

    public void setB(BeanB b) {
        this.b = b;
    }

    public BeanC getC() {
        return c;
    }

    public void setC(BeanC c) {
        this.c = c;
    }
}
