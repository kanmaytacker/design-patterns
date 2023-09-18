package com.scaler.lld.design.assignments.singleton;

import jdk.dynalink.Operation;

import java.util.Optional;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static FileBasedConfigurationManager instance = null;

    private  FileBasedConfigurationManagerImpl() {}

    @Override
    public String getConfiguration(String key) {
        return getProperties().getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        Optional<String> maybeString = Optional.ofNullable(getProperties().getProperty(key));
        if(maybeString.isPresent()) {
            String value = getProperties().getProperty(key);
            return convert(value, type);
        } else {
            return null;
        }
    }

    @Override
    public void setConfiguration(String key, String value) {
        getProperties().setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        if(value instanceof String) {
            String config = value.toString();
            getProperties().setProperty(key, config);
        }
    }

    @Override
    public void removeConfiguration(String key) {
        getProperties().remove(key);
    }

    @Override
    public void clear() {
        getProperties().clear();
    }

    public static FileBasedConfigurationManager getInstance() {
        if(instance == null) {
            synchronized (FileBasedConfigurationManagerImpl.class) {
                if(instance == null) {
                    instance = new FileBasedConfigurationManagerImpl();
                }
            }
        }
        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }

}