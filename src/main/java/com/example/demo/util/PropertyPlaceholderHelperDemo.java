package com.example.demo.util;

import org.springframework.util.PropertyPlaceholderHelper;
import sun.util.locale.provider.SPILocaleProviderAdapter;

import java.util.Properties;

public class PropertyPlaceholderHelperDemo {
    public static void main(String[] args) {
        PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper("${", "}");
        PropertyPlaceholderHelper.PlaceholderResolver props = new PropertyPlaceholderHelper.PlaceholderResolver() {
            @Override
            public String resolvePlaceholder(String placeholderName) {
                Properties properties = new Properties();
                properties.put("name","tsc");
                return properties.getProperty(placeholderName);
            }
        };
        String name = helper.replacePlaceholders("${name}", props);
        assert name.equals("tsc");
    }
}
