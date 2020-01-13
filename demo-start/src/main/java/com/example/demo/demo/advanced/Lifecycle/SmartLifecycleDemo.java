package com.example.demo.demo.advanced.Lifecycle;

import com.example.demo.demo.advanced.Lifecycle.auxiliary.LifecycleHello;
import com.example.demo.demo.advanced.Lifecycle.auxiliary.MySmartLifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SmartLifecycleDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBean(LifecycleHello.class);
        context.registerBean(MySmartLifecycle.class);
        context.registerShutdownHook();
        context.refresh();

        LifecycleHello lifecycleHello = context.getBean(LifecycleHello.class);
        lifecycleHello.say();

    }

}
