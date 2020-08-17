package com.example.demo.util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

public class ResourceUtilsDemo {
    public static void main(String[] args) throws FileNotFoundException {
        URL url = ResourceUtils.getURL("src\\main\\java\\com\\example\\demo\\util\\ObjectUtilsDemo.java");
        System.out.println(url);
        assert ResourceUtils.isFileURL(url);
        assert !ResourceUtils.isJarFileURL(url);
        assert !ResourceUtils.isJarURL(url);

        File file = ResourceUtils.getFile(url);
        System.out.println(file.getAbsolutePath());

//        ResourceUtils.extractJarFileURL(url);
    }
}
