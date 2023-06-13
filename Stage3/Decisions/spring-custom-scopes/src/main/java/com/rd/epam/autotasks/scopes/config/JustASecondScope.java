package com.rd.epam.autotasks.scopes.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JustASecondScope implements Scope {

    private final Map<String, Map.Entry<Integer, Object>> scopedObjects = Collections.synchronizedMap(new HashMap<>());


    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (!scopedObjects.containsKey(name) || LocalDateTime.now().getSecond() > scopedObjects.get(name).getKey()) {
            scopedObjects.put(name, Map.entry(LocalDateTime.now().getSecond(), objectFactory.getObject()));
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
        return "justASecond";
    }
}
