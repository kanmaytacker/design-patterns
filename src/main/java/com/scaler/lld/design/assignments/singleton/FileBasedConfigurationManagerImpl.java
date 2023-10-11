package com.scaler.lld.design.assignments.singleton;

import java.util.HashMap;
import java.util.Map;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static FileBasedConfigurationManager INSTANCE = null;
//    public Map<String, String> config = new HashMap<>();
//    public Map<String, > configDiffType = new HashMap<>();

    private FileBasedConfigurationManagerImpl(){}

    @Override
    public String getConfiguration(String key) {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'getConfiguration'");
        String rvalue = null;
        if (properties.containsKey(key)){
            rvalue = (String) properties.get(key);
        }
        return rvalue;
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'getConfiguration'");
        T rValue = null;
        if (properties.containsKey(key)){
            String value =  (String) properties.get(key);
            rValue = (T) convert(value, type);
        }
        return rValue;
    }

    @Override
    public void setConfiguration(String key, String value) {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'setConfiguration'");
        properties.put(key, value);
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
        properties.remove(key);
    }

    @Override
    public void clear() {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'clear'");
        properties.clear();
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