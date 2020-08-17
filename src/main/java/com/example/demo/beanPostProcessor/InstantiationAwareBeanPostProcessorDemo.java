package com.example.demo.beanPostProcessor;

import com.example.demo.auxiliary.My1InstantiationAwareBeanPostProcessor;
import com.example.demo.model.Say;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InstantiationAwareBeanPostProcessorDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.example.demo.mybean");
        context.registerBean(Say.class);
        context.registerBean(My1InstantiationAwareBeanPostProcessor.class);
        context.registerShutdownHook();
        context.refresh();

        Say bean = context.getBean(Say.class);
        bean.say();
        bean.sayHello();
    }
}
