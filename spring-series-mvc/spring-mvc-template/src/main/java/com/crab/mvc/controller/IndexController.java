package com.crab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/4/25 11:38
 */
@Controller
public class IndexController {

    @RequestMapping("/hello")
    public ModelAndView hello() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","zhangsan");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
