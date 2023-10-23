package com.scaler.lld.design.assignments.prototype;

import java.util.HashMap;

public class Registry implements ConfigurationPrototypeRegistry {

    HashMap<ConfigurationType, Configuration> storage = new HashMap<>();

    @Override
    public void addPrototype(Configuration user) {

        storage.put(user.getType(), user);

    }

    @Override
    public Configuration getPrototype(ConfigurationType type) {

        return storage.get(type);
    }

    @Override
    public Configuration clone(ConfigurationType type) {

        return (Configuration) storage.get(type).cloneObject();

    }

}
