package com.scaler.lld.design.assignments.singleton;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static FileBasedConfigurationManager instance = null;

    private  FileBasedConfigurationManagerImpl() {}

    @Override
    public String getConfiguration(String key) {
        return getProperties().getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        String value = getProperties().getProperty(key);
        if(value == null) {
            return null;
        }
        if(type.isAssignableFrom(String.class)) {
            return (T) value;
        }
        else if(type.isAssignableFrom(Integer.class)) {
            return (T) Integer.valueOf(value);
        }
        else if(type.isAssignableFrom(Double.class)) {
            return (T) Double.valueOf(value);
        }
        else if(type.isAssignableFrom(Float.class)) {
            return (T) Float.valueOf(value);
        }
        else if(type.isAssignableFrom(Boolean.class)) {
            return (T) Boolean.valueOf(value);
        }
        else {
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
            String v = (String)value;
            getProperties().setProperty(key, v);
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