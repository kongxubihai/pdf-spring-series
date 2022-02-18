package com.crab.mvc.hello.service;

import org.springframework.stereotype.Service;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/18 18:07
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Service
public class HelloService {
    public String hello(String name) {
        return "hello " + name;
    }
}
