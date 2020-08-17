package com.example.demo.util;

import org.springframework.util.NumberUtils;

public class NumberUtilsDemo {
    public static void main(String[] args) {
        Integer number = NumberUtils.parseNumber("1", Integer.class);
        assert number == 1;
    }
}
