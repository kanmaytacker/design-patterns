package com.scaler.lld.design.assignments.prototype;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Configuration implements  Configurable{
    private String configId;
    private Boolean configName;
    private String configValue;
    private Boolean isEnabled;
    private ConfigurationType type;

    public String getConfigId() {
        return configId;
    }

    public Boolean getConfigName() {
        return configName;
    }

    public String getConfigValue() {
        return configValue;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public ConfigurationType getType() {
        return type;
    }

    @Override
    public Configuration cloneObject() {
        return new Configuration(configId,configName,configValue,isEnabled,type);
    }
}

