package com.crab.spring.ioc.demo13;

/**
 * 模拟数据源
 * @author zfd
 * @version v1.0
 * @date 2022/1/22 20:51
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class DataSource {
    private String type;
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
