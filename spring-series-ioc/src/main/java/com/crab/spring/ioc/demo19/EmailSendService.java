package com.crab.spring.ioc.demo19;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用于发送事件
 *
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 12:03
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
public class EmailSendService {
    @Autowired
    private ApplicationEventPublisher publisher;
    // 邮件黑名单
    private List<String> blockedList;


    public void sendEmail(String address, String content) {
        if (blockedList.contains(address)) {
            System.out.println("不允许发邮件，同步发布通知事件");
            publisher.publishEvent(new BlockedListEvent(this, address, content));
            System.out.println("同步发布通知事件结束");
            return;
        }
        // 允许
        System.out.println("允许发邮件");
    }
    public void setBlockedList(List<String> blockedList) {
        this.blockedList = blockedList;
    }
}
