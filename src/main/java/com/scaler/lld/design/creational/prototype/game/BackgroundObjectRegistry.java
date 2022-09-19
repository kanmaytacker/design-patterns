package com.scaler.lld.design.creational.prototype.game;

import java.util.HashMap;
import java.util.Map;

public class BackgroundObjectRegistry {

    private Map<BackgroundObjectType, BackgroundObject> objects = new HashMap<>();

    public void registerObject(BackgroundObject object) {
        objects.put(object.getType(), object);
    }

    public BackgroundObject getObject(BackgroundObjectType type) {
        return objects.get(type);
    }
}
