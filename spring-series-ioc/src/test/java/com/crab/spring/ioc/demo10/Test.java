package com.crab.spring.ioc.demo10;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/13 15:11
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Test {

@org.junit.Test
public void test() {
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);
    MovieRecommender recommender = context.getBean(MovieRecommender.class);
    System.out.println(recommender);
    context.close();
}

@org.junit.Test
public void test1() {
    System.out.println("开始初始化容器");
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);
    FoodRecommender bean = context.getBean(FoodRecommender.class);
    System.out.println("使用容器中");
    System.out.println("销毁容器");
    context.close();
}



}
