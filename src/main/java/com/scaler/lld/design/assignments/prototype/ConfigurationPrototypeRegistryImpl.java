package com.scaler.lld.design.assignments.prototype;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ConfigurationPrototypeRegistryImpl implements ConfigurationPrototypeRegistry {
    Map<ConfigurationType, Configuration> configurationRegistry = new HashMap<>();

    @Override
    public void addPrototype(Configuration user) {
        configurationRegistry.put(user.getType(), user);
    }

    @Override
    public Configuration getPrototype(ConfigurationType type) {
        return configurationRegistry.get(type);
    }

    @Override
    public Configuration clone(ConfigurationType type) {
        Configuration configuration = getPrototype(type);
        if(Objects.nonNull(configuration)) {
            return configuration.cloneObject();
        }
        return null;
    }
}
