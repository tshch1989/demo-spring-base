package com.example.demo.util;

import org.springframework.util.DigestUtils;

public class DigestUtilsDemo {
    public static void main(String[] args) {
        String digestAsHex = DigestUtils.md5DigestAsHex("hahkdsfkdsjf".getBytes());
        System.out.println(digestAsHex);
    }
}
