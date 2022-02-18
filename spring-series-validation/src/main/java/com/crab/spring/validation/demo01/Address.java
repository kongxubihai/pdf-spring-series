package com.crab.spring.validation.demo01;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/12 10:55
 */
@Data
@AllArgsConstructor
public class Address {
    private String name;
    private int code;
}
