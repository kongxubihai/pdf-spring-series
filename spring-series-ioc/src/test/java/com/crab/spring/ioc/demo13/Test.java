package com.crab.spring.ioc.demo13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/22 21:02
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Test {

    @org.junit.Test
    public void test_profile() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
//        context.getEnvironment().setActiveProfiles("prod");
        context.register(AppConfig.class);
        context.refresh();
        DataSource dataSource = context.getBean(DataSource.class);
        System.out.println(dataSource.getType());
        context.close();
    }

    @org.junit.Test
    public void test_property_source() {
        ApplicationContext ctx = new GenericApplicationContext();
        Environment env = ctx.getEnvironment();
        boolean containsMyProperty = env.containsProperty("my-property");
        System.out.println("Does my environment contain the 'my-property' property? " + containsMyProperty);
    }

    @org.junit.Test
    public void test_custom_property_source() {

        ConfigurableApplicationContext ctx = new GenericApplicationContext();
        MutablePropertySources sources = ctx.getEnvironment().getPropertySources();
        Map<String, Object> map = new HashMap<>();
        map.put("my-property", "xxx");
        sources.addFirst(new MyPropertySource("myPropertySource", map));
        boolean containsMyProperty = ctx.getEnvironment().containsProperty("my-property");
        System.out.println("Does my environment contain the 'my-property' property? " + containsMyProperty);
    }
    @org.junit.Test
    public void test_property_source_annotation() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig3.class);
        TestBean testBean = context.getBean(TestBean.class);
        System.out.println(testBean.getName());
    }


}
