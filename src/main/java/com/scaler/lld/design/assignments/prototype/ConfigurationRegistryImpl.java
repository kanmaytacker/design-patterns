package com.scaler.lld.design.assignments.prototype;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationRegistryImpl implements ConfigurationPrototypeRegistry{
    private Map<ConfigurationType, Configuration> registry = new HashMap<>();

    @Override
    public void addPrototype(Configuration user)
    {
        registry.put(user.getType(), user);
    }

    @Override
    public Configuration getPrototype(ConfigurationType type) {
        return registry.get(type);
    }

    @Override
    public Configuration clone(ConfigurationType type) {
        return getPrototype(type).cloneObject();
    }
}
