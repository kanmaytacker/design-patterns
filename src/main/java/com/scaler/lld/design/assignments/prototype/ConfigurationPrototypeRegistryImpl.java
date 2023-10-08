package com.scaler.lld.design.assignments.prototype;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationPrototypeRegistryImpl implements ConfigurationPrototypeRegistry{

    private Map<ConfigurationType,Configuration> configurationMap = new HashMap<>();
    @Override
    public void addPrototype(Configuration user) {
        configurationMap.put(user.getType(), user);

    }

    @Override
    public Configuration getPrototype(ConfigurationType type) {
        return configurationMap.get(type);
    }

    @Override
    public Configuration clone(ConfigurationType type) {
        return configurationMap.get(type).cloneObject();
    }
}
