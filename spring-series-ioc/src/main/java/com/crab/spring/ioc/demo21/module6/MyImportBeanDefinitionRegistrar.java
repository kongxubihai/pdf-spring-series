package com.crab.spring.ioc.demo21.module6;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/3/3 17:56
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println("通过手动MyImportBeanDefinitionRegistrar方式注入service1和service2");
        AbstractBeanDefinition service1Definition =
                BeanDefinitionBuilder.rootBeanDefinition(Service1.class).getBeanDefinition();
        registry.registerBeanDefinition("service1", service1Definition);

        AbstractBeanDefinition service2Definition = BeanDefinitionBuilder.rootBeanDefinition(Service2.class)
                // 设置属性值引用
                .addPropertyReference("service1", "service1")
                .getBeanDefinition();
        registry.registerBeanDefinition("service2", service2Definition);
    }
}
