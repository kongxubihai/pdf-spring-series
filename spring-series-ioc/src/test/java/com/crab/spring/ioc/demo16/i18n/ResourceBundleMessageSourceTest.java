package com.crab.spring.ioc.demo16.i18n;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 10:33
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class ResourceBundleMessageSourceTest {
    @Test
    public void test1() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        MyBean myBean = context.getBean(MyBean.class);
        myBean.execute();
        myBean.execute1();
        myBean.getChinesMessage();
    }
}
