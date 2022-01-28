package com.crab.spring.ioc.demo20;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/28 16:13
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class MyComponentTest {
    /**
     *
     */
    @Test
    public void test(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyComponent.class);
        MyComponent bean = context.getBean(MyComponent.class);
        System.out.println(bean);
        // MyComponent{language='zh', locale='zh', name='dell'}
    }

}
