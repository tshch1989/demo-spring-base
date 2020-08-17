package com.example.demo.util;

import org.springframework.util.AntPathMatcher;

import java.util.Map;

//ant 样式路径匹配
public class AntPathMatcherDemo {
    public static void main(String[] args) {
        AntPathMatcher matcher = new AntPathMatcher();

        String pattern = "/test/{name}/show";

        String path = "/test/tsc/show";
        boolean match = matcher.match(pattern, path);
        assert match;

        Map<String, String> uriTemplateVariables = matcher.extractUriTemplateVariables(pattern, path);
        for (Map.Entry<String, String> entry : uriTemplateVariables.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
            assert "name".equals(key);
            assert "tsc".equals(value);
        }
    }
}
