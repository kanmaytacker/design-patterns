package com.scaler.lld.design.assignments.singleton;

import java.util.HashMap;
import java.util.Map;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static FileBasedConfigurationManager INSTANCE = null;
    public Map<String, String> config = new HashMap<>();
//    public Map<String, > configDiffType = new HashMap<>();

    @Override
    public String getConfiguration(String key) {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'getConfiguration'");
        String rvalue = "stringValue";
        if (config.containsKey(key)){
            rvalue = config.get(key);
        }
        return rvalue;
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getConfiguration'");
    }

    @Override
    public void setConfiguration(String key, String value) {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'setConfiguration'");
        config.put(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setConfiguration'");

    }

    @Override
    public void removeConfiguration(String key) {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'removeConfiguration'");
        config.put(key, null);
    }

    @Override
    public void clear() {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'clear'");
        config.clear();
    }

    public static FileBasedConfigurationManager getInstance() {
        if (INSTANCE == null){
            synchronized (FileBasedConfigurationManagerImpl.class){
                if (INSTANCE == null){
                    INSTANCE = new FileBasedConfigurationManagerImpl();
                }
            }
        }
        return INSTANCE;
    }

    public static void resetInstance() {
        INSTANCE = null;
    }

}