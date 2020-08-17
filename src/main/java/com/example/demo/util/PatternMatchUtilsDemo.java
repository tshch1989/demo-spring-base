package com.example.demo.util;

import org.springframework.util.PatternMatchUtils;

//简单路径匹配
public class PatternMatchUtilsDemo {
    public static void main(String[] args) {
        boolean match = PatternMatchUtils.simpleMatch("*aa", "dsfjdsaaa");
        assert match;
    }
}
