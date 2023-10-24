package com.scaler.lld.design.solutions.singleton;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static FileBasedConfigurationManagerImpl INSTANCE;

    private FileBasedConfigurationManagerImpl() {
    }

    @Override
    public String getConfiguration(String key) {
        return getProperties().getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        String value = getProperties().getProperty(key);
        if(value != null)
            return convert(getProperties().getProperty(key), type);
        return null;
    }

    @Override
    public void setConfiguration(String key, String value) {
        getProperties().setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        getProperties().setProperty(key, value.toString());
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
        if (INSTANCE == null){
            synchronized (FileBasedConfigurationManagerImpl.class) {
                if(INSTANCE == null){
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