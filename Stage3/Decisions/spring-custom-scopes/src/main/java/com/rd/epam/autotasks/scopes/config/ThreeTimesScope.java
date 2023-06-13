package com.rd.epam.autotasks.scopes.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ThreeTimesScope implements Scope {
    private final Map<String, Object> scopedObjects =
            Collections.synchronizedMap(new HashMap<>());
    private final Map<String, Integer> invokeTimes =
            Collections.synchronizedMap(new HashMap<>());

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (!scopedObjects.containsKey(name) || invokeTimes.get(name) == 3) {
            scopedObjects.put(name, objectFactory.getObject());
            invokeTimes.put(name,1);
        } else {
            invokeTimes.put(name,invokeTimes.get(name) + 1);
        }
        return scopedObjects.get(name);
    }

    @Override
    public Object remove(String name) {
        return null;
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
