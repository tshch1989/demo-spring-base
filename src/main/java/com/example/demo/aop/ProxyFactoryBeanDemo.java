package com.example.demo.aop;

import com.example.demo.aop.auxiliary.Hello;
import com.example.demo.aop.auxiliary.MyAdvice;
import com.example.demo.aop.auxiliary.MyHello;
import org.springframework.aop.framework.ProxyFactoryBean;

public class ProxyFactoryBeanDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTargetClass(Hello.class);
        proxyFactoryBean.setTarget(new MyHello());
        proxyFactoryBean.addInterface(Hello.class);
        proxyFactoryBean.addAdvice(new MyAdvice());

        Hello hello = (Hello) proxyFactoryBean.getObject();
        hello.sayHello();
        hello.sayHello2();
    }

}
