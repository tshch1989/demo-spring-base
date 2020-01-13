package com.example.demo.demo.advanced.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;

public class PathMatchingResourcePatternResolverDemo {
    public static void main(String[] args) throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // Resource[] resources =
        // resolver.getResources("classpath*:com/example/demo/**/*.class");
        // 扫描jar中的内容
        Resource[] resources = resolver.getResources("classpath*:org/springframework/core/**/*.class");
        for (Resource resource : resources) {
            System.out.println(resource.getURI().toString());

            // 加载类元数据
            SimpleMetadataReaderFactory factory = new SimpleMetadataReaderFactory();
            MetadataReader reader = factory.getMetadataReader(resource);
            System.out.println(reader.getClassMetadata().getClassName());
        }
    }
}
