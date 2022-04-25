package com.crab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 返回字符串
 *
 * @author zfd
 * @version v1.0
 * @date 2022/4/25 17:15
 */
@Controller
@RequestMapping("/string")
public class StringController {

    /**
     * 返回视图名称
     *
     * @return
     */
    @GetMapping("1")
    public String m1(Model model) {
        model.addAttribute("name", "xxx");
        return "hello";
    }

    /**
     * 服务端跳转
     *
     * @return
     */
    @GetMapping("2")
    public String m2() {
        return "forward:/hello";
    }

    /**
     * 客户端跳转
     *
     * @return
     */
    @GetMapping("3")
    public String m3() {
        return "redirect:/hello";
    }

    /**
     * 返回一个纯字符串
     *
     * @return
     */
    @GetMapping("4")
    @ResponseBody
    public String m4() {
        return "a string";
    }


}
