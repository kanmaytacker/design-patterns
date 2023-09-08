package com.scaler.lld.design.assignments.prototype;

public interface ConfigurationPrototypeRegistry {

    void addPrototype(Configuration user);

    Configuration getPrototype(ConfigurationType type);

    Configuration clone(ConfigurationType type);
}