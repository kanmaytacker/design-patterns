package com.scaler.lld.design.assignments.prototype;

import java.util.HashMap;

public class ConfigurationPrototypeRegistryImpl implements ConfigurationPrototypeRegistry{
    private HashMap<ConfigurationType, Configuration> registry = new HashMap<>();
    @Override
    public void addPrototype(Configuration user) {
        registry.put(user.getType(), user);
    }

    @Override
    public Configuration getPrototype(ConfigurationType type) {
        return registry.get(type);
    }

    @Override
    public Configuration clone(ConfigurationType type) {
        Configuration config = registry.get(type);
        if(config == null) return null;
        return config.cloneObject();
    }
}
