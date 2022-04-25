package com.crab.mvc.service;

import org.springframework.stereotype.Service;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/4/25 16:10
 */
@Service
public class HelloService {
    public String getName(String name) {
        return "hello " + name;
    }
}
