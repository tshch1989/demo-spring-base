package com.example.demo.demo.advanced.scope.auxiliary;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyScope implements Scope {

    private Map<String, Object> cacheObjects = new ConcurrentHashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object object = cacheObjects.get(name);
        if (object == null) {
            object = objectFactory.getObject();
            cacheObjects.putIfAbsent(name, object);
        }
        return cacheObjects.get(name);
    }

    @Override
    public Object remove(String name) {
        return cacheObjects.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
