package com.example.demo.util;

import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class CollectionUtilsDemo {
    public static void main(String[] args) {
        List<?> list = CollectionUtils.arrayToList(new String[]{"1", "2"});
        System.out.println(list);

        boolean empty = CollectionUtils.isEmpty(new HashMap<>());
        assert empty;

        LinkedList<Object> list1 = new LinkedList<>();
        CollectionUtils.mergeArrayIntoCollection(new String[]{"1", "2"}, list1);
        assert list1.size() == 2;

        Properties props = new Properties();
        props.put("hahah", "heihiehie");
        HashMap<String, String> map = new HashMap<>();
        CollectionUtils.mergePropertiesIntoMap(props, map);
        assert map.size() == 1;

    }
}
