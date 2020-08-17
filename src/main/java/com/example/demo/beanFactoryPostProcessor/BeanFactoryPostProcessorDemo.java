package com.example.demo.beanFactoryPostProcessor;

import com.example.demo.auxiliary.My1BeanFactoryPostProcessor;
import com.example.demo.model.Say;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanFactoryPostProcessorDemo {

    public static void main(String[] args) {
        demo1();
    }

    /**
     * 在My1BeanFactoryPostProcessor中更改Say的bean定义，添加了name1,name2的值
     */
    private static void demo1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.example.demo.mybean");
        context.registerBean(Say.class);
        context.registerBean(My1BeanFactoryPostProcessor.class);
        context.registerShutdownHook();
        context.refresh();
        Say say = context.getBean(Say.class);
        say.sayHello();
    }

}
