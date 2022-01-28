package com.crab.spring.ioc.demo20;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/1/28 15:58
 * @关于我 请关注公众号 螃蟹的Java笔记 获取更多技术系列
 */
public class TestBeanDefinition {

    /**
     * xml方式在bean定义中使用SpEL
     */
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("demo20/spring.xml");
        Map<String, MyBean> beansOfType = context.getBeansOfType(MyBean.class);
        beansOfType.entrySet().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
        context.close();
        // myBean : MyBean{randomNumber=96.83424589447431, name='dell'}
        // myBean2 : MyBean{randomNumber=96.83424589447431, name='96.83424589447431'}
    }

}
