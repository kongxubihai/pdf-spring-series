package com.crab.spring.ioc.demo03;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/13 15:53
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class ComplexObject {
    //属性
    private Properties adminEmails;
    //列表
    private List<Object> someList;
    // map
    private Map<String, Object> someMap;
    // set
    private Set<Object> someSet;



    public Properties getAdminEmails() {
        return adminEmails;
    }

    public void setAdminEmails(Properties adminEmails) {
        this.adminEmails = adminEmails;
    }

    public List<Object> getSomeList() {
        return someList;
    }

    public Map<String, Object> getSomeMap() {
        return someMap;
    }

    public void setSomeMap(Map<String, Object> someMap) {
        this.someMap = someMap;
    }

    public Set<Object> getSomeSet() {
        return someSet;
    }

    public void setSomeSet(Set<Object> someSet) {
        this.someSet = someSet;
    }

    public void setSomeList(List<Object> someList) {
        this.someList = someList;
    }
}
