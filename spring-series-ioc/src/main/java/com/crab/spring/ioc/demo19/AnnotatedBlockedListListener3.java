package com.crab.spring.ioc.demo19;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 事件监听器
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 13:32
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component

public class AnnotatedBlockedListListener3 {

    @Order(1)
    @EventListener(value = BlockedListEvent.class)
    public List<ResultEvent> onApplicationEvent(BlockedListEvent event) {
        System.out.println("邮件处理完毕，返回多个通知ResultEvent事件");
        List<ResultEvent > resultEvents = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            resultEvents.add(new ResultEvent(event.getSource(), "success:" + i));
        }
        return resultEvents;
    }
}
