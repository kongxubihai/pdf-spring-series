package com.crab.spring.aop.demo01;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/3 14:28
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class AppConfigTest {

    @Test
    public void m() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        IService bean = context.getBean(IService.class);
        bean.add("xxx");
        context.close();
    }
}
