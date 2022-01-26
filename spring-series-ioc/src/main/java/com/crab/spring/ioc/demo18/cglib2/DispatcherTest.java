package com.crab.spring.ioc.demo18.cglib2;

import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.LazyLoader;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 8:54
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class DispatcherTest {
    static class  MyRepository{
        public void m() {
            // 输出类实例
            System.out.println(this);
        }
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyRepository.class);
        enhancer.setCallback(new Dispatcher() {
            @Override
            public Object loadObject() throws Exception {
                System.out.println("回调 Dispatcher loadObject");
                return new MyRepository();
            }
        });

        Object proxy = enhancer.create();
        MyRepository myRepository = (MyRepository) proxy;
        System.out.println("第1次 MyRepository m()");
        myRepository.m();
        System.out.println("第2次 MyRepository m()");
        myRepository.m();

    }
}
