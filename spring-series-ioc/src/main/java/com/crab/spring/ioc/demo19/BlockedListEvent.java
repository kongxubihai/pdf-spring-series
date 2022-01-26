package com.crab.spring.ioc.demo19;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 12:01
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class BlockedListEvent extends ApplicationEvent {

    private final String address;
    private final String content;

    public BlockedListEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }
}
