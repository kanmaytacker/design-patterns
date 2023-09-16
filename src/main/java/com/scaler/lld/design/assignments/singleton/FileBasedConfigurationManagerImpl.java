package com.scaler.lld.design.assignments.singleton;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static  FileBasedConfigurationManagerImpl INSTANCE = null;

    private FileBasedConfigurationManagerImpl() {
        super();
    }

    @Override
    public String getConfiguration(String key) {
       return  properties.getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        return convert(properties.getProperty(key), type);
    }

    @Override
    public void setConfiguration(String key, String value) {
       properties.setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        properties.setProperty(key, String.valueOf((value)));
    }

    @Override
    public void removeConfiguration(String key) {
       properties.remove(key);
    }

    @Override
    public void clear() {
        if(!properties.isEmpty()) {
            properties.clear();
        }
    }

    public static FileBasedConfigurationManager getInstance() {
        if(INSTANCE == null ){
            synchronized (FileBasedConfigurationManager.class){
                if(INSTANCE == null){
                    INSTANCE = new FileBasedConfigurationManagerImpl() ;
                }
            }
        }
        return INSTANCE;
    }

    public static void resetInstance() {
        if(INSTANCE != null ){
            INSTANCE = null;
        }
    }

}