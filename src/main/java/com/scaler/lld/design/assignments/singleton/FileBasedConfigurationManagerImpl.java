package com.scaler.lld.design.assignments.singleton;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {


    private static FileBasedConfigurationManagerImpl instance;

    // Private constructor to enforce Singleton pattern
    private FileBasedConfigurationManagerImpl() {
    }
    @Override
    public String getConfiguration(String key) {

        return properties.getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {

        String value = properties.getProperty(key);
        if (value != null) {
            return convert(value, type);
        }
        return null;
    }

    @Override
    public void setConfiguration(String key, String value) {

        properties.setProperty(key,value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {

        properties.setProperty(key,value.toString());
    }

    @Override
    public void removeConfiguration(String key) {

        properties.remove(key);

    }

    @Override
    public void clear() {

        properties.clear();
    }

    public static FileBasedConfigurationManager getInstance() {
        // TODO Auto-generated method stub
        if (instance == null) {
            instance = new FileBasedConfigurationManagerImpl();
        }
        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }

}