package com.example.demo.demo.advanced.util;

import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class ClassPathBeanDefinitionScannerDemo {
    public static void main(String[] args) {
        SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
        scanner.setIncludeAnnotationConfig(false);//忽略一些注解处理器
        scanner.addIncludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                String className = metadataReader.getClassMetadata().getClassName();
                return className.startsWith("com.example.demo.manual")
                        || className.startsWith("org.springframework.core.type.filter");
            }
        });
        int scan = scanner.scan("com.example.demo", "org.springframework.core.type.filter");
        System.out.println(scan);
        for (String beanDefinitionName : registry.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }
}
