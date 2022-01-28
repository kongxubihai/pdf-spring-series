package com.crab.spring.ioc.demo20;

/**
 * 出生地点
 * @author zfd
 * @version v1.0
 * @date 2022/1/27 11:47
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class PlaceOfBirth {

    private String city;
    private String country;

    public PlaceOfBirth(String city) {
        this.city = city;
    }

    public PlaceOfBirth(String city, String country) {
        this(city);
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String s) {
        this.city = s;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
