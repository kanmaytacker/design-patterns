package com.scaler.lld.design.assignments.singleton;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static FileBasedConfigurationManagerImpl fileBasedConfigurationManager=null;


    private FileBasedConfigurationManagerImpl(){

    }
    @Override
    public String getConfiguration(String key) {
        return properties.getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {

        return properties.getProperty(key)!=null?convert(properties.getProperty(key),type):null;
    }

    @Override
    public void setConfiguration(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        properties.setProperty(key, value.toString());

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

        if(fileBasedConfigurationManager==null){
            synchronized (FileBasedConfigurationManagerImpl.class){
                if(fileBasedConfigurationManager==null){
                    fileBasedConfigurationManager=new FileBasedConfigurationManagerImpl();
                }
            }
        }
        return fileBasedConfigurationManager;
    }

    public static void resetInstance() {
        synchronized (FileBasedConfigurationManagerImpl.class) {
            fileBasedConfigurationManager = null;
        }
    }

}