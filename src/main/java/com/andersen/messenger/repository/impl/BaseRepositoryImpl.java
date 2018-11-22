package com.andersen.messenger.repository.impl;

import com.andersen.messenger.entity.BaseEntity;

import java.util.HashMap;

public class BaseRepositoryImpl<T extends BaseEntity> {
    protected HashMap<Integer, T> map = new HashMap<>();

    protected T findEntity(Integer id) {
        return map.get(id);
    }

    protected boolean addEntity(T entity) {
        boolean result = false;
        if (!hasId(entity.getId())) {
            map.put(entity.getId(), entity);
            result = true;
        }
        printCurrentState();
        return result;
    }

    protected boolean removeEntity(Integer id) {
        boolean result = false;
        if (hasId(id)) {
            map.remove(id);
            result = true;
        }
        printCurrentState();
        return result;
    }

    private boolean hasId(Integer id) {
        return map.get(id) != null;
    }

    private void printCurrentState() {
        String result = "Current state of Repository:\n";
        for (T entity: map.values()) {
            result += entity.toString() + "\n";
        }
        System.out.println(result);
    }
}
