package com.crab.spring.ioc.demo10;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/19 10:30
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
public class MovieRecommender {
   private final  String catalog;

   public MovieRecommender(@Value("${catalog.name:defaultCatalog}") String catalog) {
      this.catalog = catalog;
   }

   @Override
   public String toString() {
      return "MovieRecommender{" +
              "catalog='" + catalog + '\'' +
              '}';
   }
}

