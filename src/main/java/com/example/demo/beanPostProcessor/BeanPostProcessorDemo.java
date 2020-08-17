package com.example.demo.beanPostProcessor;

import com.example.demo.auxiliary.My1BeanPostProcessor;
import com.example.demo.model.Say;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanPostProcessorDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.example.demo.mybean");
        context.registerBean(Say.class);
        context.registerBean(My1BeanPostProcessor.class);
        context.registerShutdownHook();
        context.refresh();

        Say say = context.getBean(Say.class);

        say.sayHello();

    }

}
