package com.crab.spring.ioc.demo21.module6;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/3/3 17:55
 */
public class Service2 {
    private Service1 service1;

    public Service1 getService1() {
        return service1;
    }

    public void setService1(Service1 service1) {
        this.service1 = service1;
    }

    @Override
    public String toString() {
        return "Service2{" +
                "service1=" + service1 +
                '}';
    }
}
