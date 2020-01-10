package com.example.demo.demo.advanced.beanPostProcessor;

import com.example.demo.demo.advanced.auxiliary.My1BeanPostProcessor;
import com.example.demo.manual.Say;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanPOstProcessorDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.example.demo.mybean");
        context.registerBean(Say.class);
        context.registerBean(My1BeanPostProcessor.class);
        context.refresh();

        Say say = context.getBean(Say.class);

        say.sayHello();

    }

}
