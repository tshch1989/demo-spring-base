package com.example.demo.util;

import org.springframework.util.StringUtils;

import java.util.LinkedList;
import java.util.Set;

//字符操作相关
public class StringUtilsDemo {
    public static void main(String[] args) {
        assert StringUtils.isEmpty("");

        String[] ss = StringUtils.addStringToArray(new String[]{}, "111");
        assert ss[0].equals("111");

        String s = StringUtils.arrayToCommaDelimitedString(new Object[]{"1", "2", "3"});
        String comStr = "1,2,3";
        assert comStr.equals(s);

        LinkedList<Object> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        String s1 = StringUtils.collectionToCommaDelimitedString(list);
        assert comStr.equals(s1);

        Set<String> s3 = StringUtils.commaDelimitedListToSet(comStr);
        System.out.println(s3);
        assert s3.size() == 3;

        String[] ss4 = StringUtils.tokenizeToStringArray("aaa,bbb,ccc*ddd", ",*");
        assert ss4.length == 4;
    }
}
