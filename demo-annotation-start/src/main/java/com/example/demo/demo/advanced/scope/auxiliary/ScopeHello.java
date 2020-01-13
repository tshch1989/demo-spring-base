package com.example.demo.demo.advanced.scope.auxiliary;

import org.springframework.context.annotation.Scope;

@Scope("myScope")
public class ScopeHello {

    public void say(){
        System.out.println("Hello myScope...");
    }

}
