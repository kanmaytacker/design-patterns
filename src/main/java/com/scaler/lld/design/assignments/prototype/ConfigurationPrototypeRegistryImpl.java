package com.scaler.lld.design.assignments.prototype;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationPrototypeRegistryImpl implements  ConfigurationPrototypeRegistry{

    private Map<ConfigurationType,Configuration> map=new HashMap<>();
    @Override
    public void addPrototype(Configuration user) {
        map.put(user.getType(),user);
    }

    @Override
    public Configuration getPrototype(ConfigurationType type) {
        if(map.containsKey(type)) return map.get(type);
        return null;
    }

    @Override
    public Configuration clone(ConfigurationType type) {
        if(map.containsKey(type)){
            return map.get(type).cloneObject();
        }
        return null;
    }
}
