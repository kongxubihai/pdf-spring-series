package com.crab.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * 参数绑定演示
 *
 * @author zfd
 * @version v1.0
 * @date 2022/4/25 17:30
 */
@RestController
public class ParameterBindController {

    @GetMapping("/getDate")
    public String getDate(Integer id, Date date) {
        return id + date.toString();
    }
}
