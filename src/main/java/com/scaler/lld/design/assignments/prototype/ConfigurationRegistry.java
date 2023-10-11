package com.scaler.lld.design.assignments.prototype;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationRegistry implements ConfigurationPrototypeRegistry{
    private Map<ConfigurationType, Configuration> registy = new HashMap<>();
    @Override
    public void addPrototype(Configuration user) {
        registy.put(user.getType(), user);
    }

    @Override
    public Configuration getPrototype(ConfigurationType type) {
        return registy.get(type);
    }

    @Override
    public Configuration clone(ConfigurationType type) {
        Configuration config = registy.get(type);
        return (Configuration) config.cloneObject();
    }
}
