package com.crab.spring.ioc.demo21.module5;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/3/3 17:35
 */
public class MyDeferredImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{MyConfiguration7.class.getName()};
    }
}
