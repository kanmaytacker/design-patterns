package com.scaler.lld.design.assignments.prototype;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationPrototypeRegistryImpl implements ConfigurationPrototypeRegistry{

    private Map<ConfigurationType, Configuration> registryMap = new HashMap<>();


    @Override
    public void addPrototype(Configuration user) {
        registryMap.putIfAbsent(user.getType(), user);
    }

    @Override
    public Configuration getPrototype(ConfigurationType type) {
        return registryMap.get(type);
    }

    @Override
    public Configuration clone(ConfigurationType type) {
        return registryMap.get(type).cloneObject();
    }
}
