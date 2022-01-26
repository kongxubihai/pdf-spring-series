package com.crab.spring.ioc.demo19;

import org.springframework.context.ApplicationEvent;

/**
 * 上一个监听者的处理结果作为结果事件发布
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 12:01
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class ResultEvent extends ApplicationEvent {

    private final String result;

    public ResultEvent(Object source,  String result) {
        super(source);
        this.result = result;
    }


    public String getResult() {
        return result;
    }
}
