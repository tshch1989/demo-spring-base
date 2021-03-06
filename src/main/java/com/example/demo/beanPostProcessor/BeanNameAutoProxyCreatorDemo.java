package com.example.demo.beanPostProcessor;

import com.example.demo.aop.auxiliary.Hello;
import com.example.demo.aop.auxiliary.MyAdvice;
import com.example.demo.aop.auxiliary.MyHello;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class BeanNameAutoProxyCreatorDemo {

    public static void main(String[] args) {

        BeanNameAutoProxyCreator proxyCreator = new BeanNameAutoProxyCreator();
        proxyCreator.setBeanNames("myHello");
        proxyCreator.setInterceptorNames("myAdvice");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBean(MyHello.class);
        context.registerBean(MyAdvice.class);
        context.registerBean("beanNameAutoProxyCreator",
                BeanNameAutoProxyCreator.class,
                new Supplier<BeanNameAutoProxyCreator>() {
                    @Override
                    public BeanNameAutoProxyCreator get() {
                        return proxyCreator;
                    }
                });
        context.registerShutdownHook();
        context.refresh();

        Hello hello = context.getBean(Hello.class);

        hello.sayHello();
        hello.sayHello2();
    }

}
