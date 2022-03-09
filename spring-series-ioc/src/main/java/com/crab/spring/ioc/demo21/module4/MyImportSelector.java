package com.crab.spring.ioc.demo21.module4;

import com.crab.spring.ioc.demo21.module3.Service3;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/**
 * @author zfd
 * @version v1.0
 * @date 2022/3/3 17:13
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Service4.class.getName(), Service3.class.getName()};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
         return className -> className.startsWith("com.crab.spring.ioc.demo21.module3.");
    }
}
