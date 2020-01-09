package com.example.demo.demo.base;

import com.example.demo.manual.Say;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.*;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * 环境操作演示
 */
public class EnvironmentDemo {

    public static void main(String[] args) throws IOException {
        demo1();
        demo2();
    }

    /**
     * 解析占位符演示
     */
    public static void demo1(){
        StandardEnvironment environment = new StandardEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        HashMap<String, Object> myProps = new HashMap<>();
        myProps.put("name1", "tshch1989@sina.com");
        PropertySource<?> propertySource =
                new MapPropertySource("myPropertySource", myProps);
        propertySources.addLast(propertySource);

        String placeholders = environment.resolvePlaceholders("${name1}");
        System.out.println(placeholders);

    }

    public static void demo2() throws IOException {
        ClassPathResource resource = new ClassPathResource("application.properties");
        Properties properties = new Properties();
        properties.load(resource.getInputStream());
        PropertiesPropertySource propertySource =
                new PropertiesPropertySource("myPropertySource",properties);
        StandardEnvironment environment = new StandardEnvironment();
        environment.getPropertySources().addLast(propertySource);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.setEnvironment(environment);
        context.scan("com.example.demo.mybean");
        context.registerBean(Say.class);
        context.refresh();
        Say say = context.getBean(Say.class);
        say.sayHello();
    }

}
