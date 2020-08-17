package com.example.demo.util;

import org.springframework.util.SystemPropertyUtils;

public class SystemPropertyUtilsDemo {
    public static void main(String[] args) {
        String placeholders = SystemPropertyUtils.resolvePlaceholders("${user.home}");
        System.out.println(placeholders);
    }
}
