package com.crab.spring.ioc.demo19;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 13:32
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
public class ConditionalBlockedListListener{
    // 当事件内容是ooo 才处理
    @EventListener(value = BlockedListEvent.class, condition = "#event.content == 'ooo'")
    public void onApplicationEvent(BlockedListEvent event) {
        System.out.println("当事件内容是ooo 才处理");
    }
}
