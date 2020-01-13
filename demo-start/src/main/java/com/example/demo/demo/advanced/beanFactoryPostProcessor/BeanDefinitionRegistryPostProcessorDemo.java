package com.example.demo.demo.advanced.beanFactoryPostProcessor;

import com.example.demo.demo.advanced.auxiliary.My1BeanDefinitionRegistryPostProcessor;
import com.example.demo.manual.Say;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionRegistryPostProcessorDemo {

    /**
     * 通过My1BeanDefinitionRegistryPostProcessor注入Say
     *
     * @param args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.example.demo.mybean");
        context.registerBean(Say.class);
        context.registerBean(My1BeanDefinitionRegistryPostProcessor.class);
        context.registerShutdownHook();
        context.refresh();
        Say say = context.getBean(Say.class);
        say.say();
    }


}
