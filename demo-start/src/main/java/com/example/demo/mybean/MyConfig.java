package com.example.demo.mybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public MySay2 mySay2() {
        return new MySay2();
    }

}
