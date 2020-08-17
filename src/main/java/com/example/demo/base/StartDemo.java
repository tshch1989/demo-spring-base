package com.example.demo.base;

import com.example.demo.model.Say;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 演示基本使用流程
 */
public class StartDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.example.demo.mybean");//包扫描方式注册bean
        context.registerBean(Say.class);
        context.registerShutdownHook();
        context.refresh();
        Say say = (Say) context.getBean("say");
        say.say();
    }

}
