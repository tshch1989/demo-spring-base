package com.example.demo.util;

import com.example.demo.aop.auxiliary.MyHello;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

//反射操作类
public class ReflectionUtilsDemo {
    public static void main(String[] args) {
        Method[] allDeclaredMethods = ReflectionUtils.getAllDeclaredMethods(MyHello.class);
        System.out.println("=======allDeclaredMethods=========");
        for (Method allDeclaredMethod : allDeclaredMethods) {
            System.out.println(allDeclaredMethod.toString());
        }

        Method[] declaredMethods = ReflectionUtils.getDeclaredMethods(MyHello.class);
        System.out.println("======declaredMethods=====");
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.toString());
        }

        Method sayHello = ReflectionUtils.findMethod(MyHello.class, "sayHello");
        assert sayHello != null;
        ReflectionUtils.invokeMethod(sayHello, new MyHello());
    }
}
