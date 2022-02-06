package com.crab.spring.aop.demo02.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/6 21:41
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Aspect
@Configuration
@EnableAspectJAutoProxy // 自动生成代理对象
public class PointcutBeanConfig {

    // 注入 myBean1
    @Bean("myBean1")
    public MyBean myBean1() {
        return new MyBean("myBean1");
    }

    //  myBean2
    @Bean("myBean2")
    public MyBean myBean2() {
        return new MyBean("myBean2");
    }

    // 注入切面
    @Bean("pointcutBean")
    public PointcutBean pointcutBean() {
        return new PointcutBean();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(PointcutBeanConfig.class);
        MyBean myBean1 = context.getBean("myBean1", MyBean.class);
        myBean1.m();
        MyBean myBean2 = context.getBean("myBean2", MyBean.class);
        myBean2.m();
    }

}
