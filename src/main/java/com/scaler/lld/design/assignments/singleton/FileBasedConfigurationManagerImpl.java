package com.scaler.lld.design.assignments.singleton;

import java.util.Optional;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static FileBasedConfigurationManagerImpl instance = null;

    private FileBasedConfigurationManagerImpl(){

    }


    @Override
    public String getConfiguration(String key) {
        return getProperties().getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        String value = getProperties().getProperty(key);
        Optional<String> checkNull = Optional.ofNullable(value);
        if(checkNull.isPresent())
            return convert(value,type);
        else
            return null;
    }

    @Override
    public void setConfiguration(String key, String value) {

        getProperties().setProperty(key,value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        getProperties().setProperty(key,value.toString());
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
        if(instance == null){
            synchronized (FileBasedConfigurationManagerImpl.class){
                if(instance == null){
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