package com.crab.spring.validation.demo01;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/2/17 18:09
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
@Data
@AllArgsConstructor
public class Customer {
    private String firstName;
    private String lastName;
    private Address address;
}
