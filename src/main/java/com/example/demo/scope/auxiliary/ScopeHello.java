package com.example.demo.scope.auxiliary;

import org.springframework.context.annotation.Scope;

@Scope("myScope")
public class ScopeHello {

    public void say() {
        System.out.println("Hello myScope...");
    }

}
