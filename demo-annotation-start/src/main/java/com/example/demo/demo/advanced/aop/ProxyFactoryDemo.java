package com.example.demo.demo.advanced.aop;

import com.example.demo.demo.advanced.aop.auxiliary.Hello;
import com.example.demo.demo.advanced.aop.auxiliary.MyAdvice;
import com.example.demo.demo.advanced.aop.auxiliary.MyHello;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

public class ProxyFactoryDemo {

    public static void main(String[] args) {
        demo1();
        System.out.println("----------------");
        demo2();
    }

    private static void demo1() {
        ProxyFactory factory = new ProxyFactory();
        factory.setInterfaces(Hello.class);
        factory.addAdvice(new MyAdvice());
        factory.setTarget(new MyHello());

        Hello proxy = (Hello) factory.getProxy();
        proxy.sayHello();
        proxy.sayHello2();
    }

    private static void demo2() {
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("sayHello");
        advisor.setAdvice(new MyAdvice());

        ProxyFactory factory = new ProxyFactory();
        factory.setInterfaces(Hello.class);
        factory.addAdvisor(advisor);
        factory.setTarget(new MyHello());

        Hello proxy = (Hello) factory.getProxy();
        proxy.sayHello();
        proxy.sayHello2();
    }

}
