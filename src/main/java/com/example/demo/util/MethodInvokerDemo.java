package com.example.demo.util;

import com.example.demo.aop.auxiliary.MyHello;
import org.springframework.util.MethodInvoker;

import java.lang.reflect.InvocationTargetException;

public class MethodInvokerDemo {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        MethodInvoker invoker = new MethodInvoker();
        invoker.setTargetClass(MyHello.class);
        invoker.setTargetObject(new MyHello());
        invoker.setTargetMethod("sayHello");
        invoker.prepare();
        if(invoker.isPrepared()){
            invoker.invoke();
        }
    }
}
