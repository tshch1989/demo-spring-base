package com.example.demo.util;

import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;

public class Base64UtilsDemo {
    public static void main(String[] args) {
        String txt = "我很好";
        String base64Str = Base64Utils.encodeToString(txt.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = Base64Utils.decodeFromString(base64Str);
        assert new String(bytes, StandardCharsets.UTF_8).equals(txt);
    }
}
