package com.crab.spring.ioc.demo18;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/25 14:19
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class OrderRepository implements Repository<String>{
    @Override
    public void add(String s) {
        System.out.println("OrderRepository add");
    }

    @Override
    public int delete(Long id) {
        System.out.println("OrderRepository delete");
        return 1;
    }
}
