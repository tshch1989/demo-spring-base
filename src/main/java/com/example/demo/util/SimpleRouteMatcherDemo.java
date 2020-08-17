package com.example.demo.util;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.RouteMatcher;
import org.springframework.util.SimpleRouteMatcher;

import java.util.Map;

public class SimpleRouteMatcherDemo {
    public static void main(String[] args) {
        SimpleRouteMatcher routeMatcher = new SimpleRouteMatcher(new AntPathMatcher());
        Map<String, String> map = routeMatcher.matchAndExtract("/test/{name}/t", new RouteMatcher.Route() {
            @Override
            public String value() {
                return "/test/tsc/t";
            }
        });
        assert map != null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            assert key.equals("name");
            assert value.equals("tsc");
        }
    }
}
