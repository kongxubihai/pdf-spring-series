package com.crab.spring.ioc.demo11;

import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PreDestroy;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/19 14:32
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class BeanThree implements DisposableBean {

    // 方式1 实现DisposableBean
    @Override
    public void destroy() throws Exception {
        System.out.println("BeanThree DisposableBean destroy");
    }
    // 方式2 xml中配置destroy-method
    public void destroy2(){
        System.out.println("BeanThree destroy-method destroy3");
    }
    // 方式3 使用 @PreDestroy 注解
    @PreDestroy
    public void destroy3(){
        System.out.println("BeanThree @PreDestroy destroy3");
    }
}
