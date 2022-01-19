package com.crab.spring.ioc.demo10;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/19 10:30
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
public class FoodRecommender {

   @PostConstruct
   public void onInit() {
      System.out.println("FoodRecommender onInit");
   }
   @PreDestroy
   public void onDestroy() {
      System.out.println("FoodRecommender onDestroy");
   }

}

