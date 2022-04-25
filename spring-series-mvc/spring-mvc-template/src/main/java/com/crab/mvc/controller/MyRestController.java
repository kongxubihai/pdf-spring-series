package com.crab.mvc.controller;

import com.crab.mvc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/4/25 14:39
 */
@RestController
public class MyRestController {
    @Autowired
    private HelloService helloService;

    @GetMapping("/test")
    public String test() {
        return helloService.getName("xxx");
    }
}
