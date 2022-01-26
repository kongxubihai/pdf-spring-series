package com.crab.spring.ioc.demo19.generic.arbitrary;

import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/26 16:06
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Component
public class PayloadApplicationEventListener {

    @EventListener
    public void onPayloadApplicationEvent(PayloadApplicationEvent<ArbitraryObject> event) {

        System.out.println("收到PayloadApplicationEvent： " + event.getPayload());
    }

}
