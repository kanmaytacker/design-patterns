package com.scaler.lld.design.assignments.prototype;
import java.util.HashMap;
import java.util.Map;
public class ConfigurationPrototypeRegistryImpl implements ConfigurationPrototypeRegistry{

    Map<ConfigurationType,Configuration> map;
    public ConfigurationPrototypeRegistryImpl()
    {
        map=new HashMap<>();
    }
    @Override
    public void addPrototype(Configuration user) {

        map.put(user.getType(),user);


    }

    @Override
    public Configuration getPrototype(ConfigurationType type) {
        return map.get(type);
    }

    @Override
    public Configuration clone(ConfigurationType type) {

        Configuration obj=map.getOrDefault(type,null);

        if(obj!=null)
        return (Configuration) obj.cloneObject();

        return null;

    }
}
