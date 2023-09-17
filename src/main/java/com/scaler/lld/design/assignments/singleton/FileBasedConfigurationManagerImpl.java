package com.scaler.lld.design.assignments.singleton;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    @Override
    public String getConfiguration(String key) {
        // TODO Auto-generated method stub
        return properties.getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        // TODO Auto-generated method stub
        if(INSTANCE!=null){
            String str=INSTANCE.properties.getProperty(key);
            if(str!=null)
                return convert(str,type);
            else
                return null;
        }
        else{
            throw new NullPointerException("Configuration Manager Instance is NULL");
        }
    }

    @Override
    public void setConfiguration(String key, String value) {
        // TODO Auto-generated method stub
        properties.setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        // TODO Auto-generated method stub
        properties.setProperty(key, value.toString());
    }

    @Override
    public void removeConfiguration(String key) {
        // TODO Auto-generated method stub
        properties.remove(key);
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        properties.clear();
    }


    private static FileBasedConfigurationManagerImpl INSTANCE;

    //step1: private constructor
    private FileBasedConfigurationManagerImpl(){

    }
    public static FileBasedConfigurationManager getInstance() {
        // TODO Auto-generated method stub
        if(INSTANCE==null){
            synchronized (FileBasedConfigurationManagerImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FileBasedConfigurationManagerImpl();
                }
            }
        }
        return INSTANCE;
    }

    public static void resetInstance() {
        // TODO Auto-generated method stub
        INSTANCE = null;
    }
}