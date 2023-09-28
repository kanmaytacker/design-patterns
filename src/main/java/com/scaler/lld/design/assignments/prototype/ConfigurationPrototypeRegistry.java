package com.scaler.lld.design.assignments.prototype;

import java.util.HashMap;
import java.util.Map;

public interface ConfigurationPrototypeRegistry {


    void addPrototype(Configuration user);

    Configuration getPrototype(ConfigurationType type);

    Configuration clone(ConfigurationType type);
}