package com.example.demo.demo.base;

import com.example.demo.manual.Say;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.springframework.beans.factory.support.AbstractBeanDefinition.AUTOWIRE_BY_TYPE;
import static org.springframework.beans.factory.support.AbstractBeanDefinition.AUTOWIRE_NO;

/**
 * 演示如何通过直接注册BeanDefinition
 */
public class BeanDefinitionDemo {

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
    }


    public static void demo1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.example.demo.mybean");//包扫描方式注册bean
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Say.class)
                .setAutowireMode(AUTOWIRE_BY_TYPE)
                .getBeanDefinition();
        context.registerBeanDefinition("say", beanDefinition);
        context.registerShutdownHook();
        context.refresh();
        Say say = (Say) context.getBean("say");
        say.say();
    }

    public static void demo2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.example.demo.mybean");//包扫描方式注册bean
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Say.class)
                .setAutowireMode(AUTOWIRE_NO)
                .addPropertyReference("mySay", "mySay")
                .addPropertyReference("mySay2", "mySay2")
                .getBeanDefinition();
        context.registerBeanDefinition("say", beanDefinition);
        context.registerShutdownHook();
        context.refresh();
        Say say = (Say) context.getBean("say");
        say.say();
    }


    public static void demo3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.example.demo.mybean");//包扫描方式注册bean
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Say.class)
                .setAutowireMode(AUTOWIRE_NO)
                .addPropertyValue("name1", "name1")
                .addPropertyValue("name2", "name2")
                .getBeanDefinition();
        context.registerBeanDefinition("say", beanDefinition);
        context.registerShutdownHook();
        context.refresh();
        Say say = (Say) context.getBean("say");
        say.sayHello();
    }
}
