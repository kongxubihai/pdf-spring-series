package com.crab.spring.ioc.demo13;

import org.springframework.core.env.PropertySource;

import java.util.Map;

/**
 * 自定义 PropertySource
 * @author zfd
 * @version v1.0
 * @date 2022/1/22 22:13
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class MyPropertySource extends PropertySource<Map<String, Object>> {


    public MyPropertySource(String name, Map<String, Object> source) {
        super(name, source);
    }

    public MyPropertySource(String name) {
        super(name);
    }

    @Override
    public Object getProperty(String name) {
        return this.source.get(name);
    }
}
