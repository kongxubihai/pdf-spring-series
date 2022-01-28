package com.crab.spring.ioc.demo20;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/28 16:02
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
@ComponentScan
public class MyComponent {

    private String language;

    @Value("#{ systemProperties['user.language']}")
    private String locale;

    private String name;

    @Value("#{ systemProperties['user.name']}")
    public void setName(String name) {
        this.name = name;
    }

    @Autowired
    public MyComponent(@Value("#{ systemProperties['user.language']}") String language) {
        this.language = language;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "MyComponent{" +
                "language='" + language + '\'' +
                ", locale='" + locale + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
