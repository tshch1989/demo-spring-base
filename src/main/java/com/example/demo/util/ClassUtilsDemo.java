package com.example.demo.util;

import com.example.demo.aop.auxiliary.Hello;
import com.example.demo.aop.auxiliary.MyHello;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;

public class ClassUtilsDemo {
    public static void main(String[] args) {
        Class<MyHello> clazz = MyHello.class;

        String shortNameAsProperty = ClassUtils.getShortNameAsProperty(clazz);
        assert shortNameAsProperty.equals("myHello");

        String shortName = ClassUtils.getShortName(clazz);
        assert shortName.equals("MyHello");

        String classNamesToString = ClassUtils.classNamesToString(clazz);
        assert "[com.example.demo.aop.auxiliary.MyHello]".equals(classNamesToString);

        String addResourcePathToPackagePath = ClassUtils.addResourcePathToPackagePath(clazz, "Hello");
        assert "com/example/demo/aop/auxiliary/Hello".equals(addResourcePathToPackagePath);

        String convertClassNameToResourcePath = ClassUtils.convertClassNameToResourcePath(clazz.getName());
        assert "com/example/demo/aop/auxiliary/MyHello".equals(convertClassNameToResourcePath);

        String convertResourcePathToClassName = ClassUtils.convertResourcePathToClassName("com/example/demo/aop/auxiliary/MyHello");
        assert "com.example.demo.aop.auxiliary.MyHello".equals(convertResourcePathToClassName);

        Class<?>[] interfaces = ClassUtils.getAllInterfaces(new MyHello());
        assert interfaces.length == 1;
        assert interfaces[0] == Hello.class;

        Class<?>[] allInterfacesForClass = ClassUtils.getAllInterfacesForClass(clazz);
        assert allInterfacesForClass.length == 1;
        assert allInterfacesForClass[0] == Hello.class;

        String classFileName = ClassUtils.getClassFileName(clazz);
        assert "MyHello.class".equals(classFileName);

        String descriptiveType = ClassUtils.getDescriptiveType(new MyHello());
        System.out.println(descriptiveType);
        assert "com.example.demo.aop.auxiliary.MyHello".equals(descriptiveType);

        String packageName = ClassUtils.getPackageName(clazz);
        assert "com.example.demo.aop.auxiliary".equals(packageName);

        String qualifiedName = ClassUtils.getQualifiedName(clazz);
        System.out.println(qualifiedName);
        assert "com.example.demo.aop.auxiliary.MyHello".equals(qualifiedName);

        boolean assignable = ClassUtils.isAssignable(Hello.class, clazz);
        assert assignable;

        Method sayHello = ClassUtils.getMethod(clazz, "sayHello");
        assert sayHello != null;
    }
}
