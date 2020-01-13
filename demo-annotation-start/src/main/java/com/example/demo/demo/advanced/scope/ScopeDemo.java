package com.example.demo.demo.advanced.scope;

import com.example.demo.demo.advanced.scope.auxiliary.MyScope;
import com.example.demo.demo.advanced.scope.auxiliary.ScopeHello;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.beans.factory.config.Scope;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class ScopeDemo {

    public static void main(String[] args) {

        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        customScopeConfigurer.addScope("myScope", new MyScope());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBean(CustomScopeConfigurer.class, new Supplier<CustomScopeConfigurer>() {
            @Override
            public CustomScopeConfigurer get() {
                return customScopeConfigurer;
            }
        });
        context.registerBean(ScopeHello.class);
        context.registerShutdownHook();
        context.refresh();

        //直接读取，对象一致
        ScopeHello scopeHello = context.getBean(ScopeHello.class);
        System.out.println(scopeHello);
        ScopeHello scopeHello1 = context.getBean(ScopeHello.class);
        System.out.println(scopeHello1);

        //删除创建的对象
        Scope myScope = context.getBeanFactory()
                .getRegisteredScope("myScope");
        myScope.remove("scopeHello");

        //产生薪的对象
        ScopeHello scopeHello2 = context.getBean(ScopeHello.class);
        System.out.println(scopeHello2);
    }

}
