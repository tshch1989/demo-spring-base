package com.example.demo.demo.advanced.aop.auxiliary;

public class MyHello implements Hello{

    @Override
    public void sayHello() {
        System.out.println("Hello AOP.");
    }

    @Override
    public void sayHello2() {
        System.out.println("Hello 2 AOP.");
    }
}
