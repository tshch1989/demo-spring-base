package com.example.demo.demo.advanced.beanFactoryPostProcessor;

import com.example.demo.manual.Say;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * 额外的属性配置
 */
public class PropertyResourceConfigurerDemo {

    public static void main(String[] args) {

        PropertySourcesPlaceholderConfigurer placeholderConfigurer =
                new PropertySourcesPlaceholderConfigurer();
        placeholderConfigurer.setLocation(new ClassPathResource("application.properties"));

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.example.demo.mybean");
        context.register(Say.class);
        context.registerBean("placeholderConfigurer",
                PropertySourcesPlaceholderConfigurer.class,
                ()->{return placeholderConfigurer;});

        context.refresh();

        Say say = context.getBean(Say.class);

        say.say();
        say.sayHello();
    }

}
