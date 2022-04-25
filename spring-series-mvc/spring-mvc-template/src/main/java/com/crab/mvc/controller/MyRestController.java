package com.crab.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/4/25 14:39
 */
@RestController
public class MyRestController {
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
