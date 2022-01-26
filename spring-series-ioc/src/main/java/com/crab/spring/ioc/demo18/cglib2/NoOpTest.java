package com.crab.spring.ioc.demo18.cglib2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.LazyLoader;
import org.springframework.cglib.proxy.NoOp;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 8:54
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class NoOpTest {
    static class  MyRepository{
        public void m() {
            // 输出类实例
            System.out.println(this);
        }
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyRepository.class);
        enhancer.setCallback(NoOp.INSTANCE);

        Object proxy = enhancer.create();
        MyRepository myRepository = (MyRepository) proxy;
        System.out.println("第1次 MyRepository m()");
        myRepository.m();
        System.out.println("第2次 MyRepository m()");
        myRepository.m();
    }
}
