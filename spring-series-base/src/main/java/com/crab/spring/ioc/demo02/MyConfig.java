package com.crab.spring.ioc.demo02;

import org.springframework.core.io.Resource;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/11 18:21
 */
public class MyConfig {
    /**
     * 通过配置文件注入的资源
     */
    private Resource template;

    public Resource getTemplate() {
        return template;
    }

    public void setTemplate(Resource template) {
        this.template = template;
    }
}
