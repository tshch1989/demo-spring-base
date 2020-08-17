package com.example.demo.Lifecycle;

import com.example.demo.Lifecycle.auxiliary.LifecycleHello;
import com.example.demo.Lifecycle.auxiliary.MySmartLifecycle;
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
