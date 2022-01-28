package com.crab.spring.ioc.demo20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 发明者协会
 * @author zfd
 * @version v1.0
 * @date 2022/1/27 11:48
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class Society {

    private String name;

    public static String Advisors = "advisors";
    public static String President = "president";

    /**
     * 发明者成员列表
     */
    private List<Inventor> members = new ArrayList<Inventor>();

    private Map officers = new HashMap();

    public List getMembers() {
        return members;
    }

    public Map getOfficers() {
        return officers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 是否是协会成员
     * @param name
     * @return
     */
    public boolean isMember(String name) {
        for (Inventor inventor : members) {
            if (inventor.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
