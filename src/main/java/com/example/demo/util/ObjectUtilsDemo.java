package com.example.demo.util;

import org.springframework.util.ObjectUtils;

import java.util.HashMap;

public class ObjectUtilsDemo {
    public static void main(String[] args) {
        String[] ss = ObjectUtils.addObjectToArray(new String[0], "111");
        assert ss[0].equals("111");

        String identityHexString = ObjectUtils.getIdentityHexString(new HashMap<>());
        System.out.println(identityHexString);

        boolean empty = ObjectUtils.isEmpty(new HashMap<>());
        assert empty;

        boolean checkedException = ObjectUtils.isCheckedException(new RuntimeException());
        assert !checkedException;

        boolean b = ObjectUtils.nullSafeEquals(null, null);
        assert !b;
    }
}
