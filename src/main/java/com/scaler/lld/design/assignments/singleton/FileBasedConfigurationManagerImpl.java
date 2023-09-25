package com.scaler.lld.design.assignments.singleton;

import java.util.Properties;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static FileBasedConfigurationManagerImpl instance = null;
    Properties s = this.properties;

    private FileBasedConfigurationManagerImpl() {

    }

    @Override
    public String getConfiguration(String key) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'getConfiguration'");
        if (s.containsKey(key)) {
            return s.getProperty(key);
        } else {
            return null;
        }

    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        T ans = null;
        if (s.containsKey(key)) {
            ans = convert(key, type);
            return ans;
        } else {
            return ans;
        }
    }

    @Override
    public void setConfiguration(String key, String value) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'setConfiguration'");
        s.setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'setConfiguration'");
    }

    @Override
    public void removeConfiguration(String key) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'removeConfiguration'");
        s.remove(key);
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'clear'");
        s.clear();
    }

    public static FileBasedConfigurationManager getInstance() {
        if (instance == null) {
            instance = new FileBasedConfigurationManagerImpl();
            return instance;
        } else {
            return instance;
        }
    }

    public static void resetInstance() {
        instance = null;
    }

}