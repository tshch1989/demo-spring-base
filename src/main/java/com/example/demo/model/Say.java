package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
public class Say {

    @Autowired
    private MySay mySay;
    @Autowired
    private MySay2 mySay2;

    @Value("${my_name}")
    private String name1;
    @Value("${my_name2}")
    private String name2;

    public Say() {
        System.out.println("Say 构造...");
    }

    public void say() {
        mySay.say();
        mySay2.say();
    }

    public void sayHello() {
        System.out.println("Hello " + name1);
        System.out.println("Hello " + name2);
    }

}
