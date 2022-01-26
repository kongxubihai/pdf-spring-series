package com.crab.spring.ioc.demo16.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 10:29
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
public class MyBean {
    @Autowired
    private MessageSource messageSource;

    // 获取消息内容
    public void execute() {
        System.out.println("获取消息内容:");
        String message = this.messageSource.getMessage("message", null, "Default", Locale.ENGLISH);
        System.out.println(message);
    }

    // 替换占位符内容 字符串形式
    public void execute1() {
        System.out.println(" 替换占位符内容 字符串形式: ");
        String message = this.messageSource.getMessage("argument.required", new Object[]{"messageSource"},
                "Required", Locale.ENGLISH);
        System.out.println(message);
    }


    // 获取中文消息
    public void getChinesMessage() {
        System.out.println("替换占位符内容 字符串形式，语言是中文: ");
        String message = this.messageSource.getMessage("argument.required", new Object[]{"messageSource"},
                "Required", Locale.CHINESE);
        System.out.println(message);
    }

}
