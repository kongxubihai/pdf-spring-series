package com.crab.spring.demo02;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/12 14:18
 */
public class FactoryBean {

    ParentBean getObj() {
        return new ChildBean();
    }

}
