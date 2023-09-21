package com.scaler.lld.design.assignments.singleton;

import java.util.Optional;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static FileBasedConfigurationManager INSTANCE;
    private FileBasedConfigurationManagerImpl() {}

    @Override
    public String getConfiguration(String key) {
        // TODO Auto-generated method stub
        return this.properties.getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        // TODO Auto-generated method stub
        Optional<String> maybeString = Optional.ofNullable(getProperties().getProperty(key));
        if(maybeString.isPresent()) {
            String value = getProperties().getProperty(key);
            return convert(value, type);
        } else {
            return null;
        }
    }

    @Override
    public void setConfiguration(String key, String value) {

        // TODO Auto-generated method stub
        this.properties.setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        // TODO Auto-generated method stub
        this.properties.setProperty(key, String.valueOf(value));

    }

    @Override
    public void removeConfiguration(String key) {

        // TODO Auto-generated method stub
        this.properties.remove(key);

    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        this.properties.clear();

    }

    public static FileBasedConfigurationManager getInstance() {
        // TODO Auto-generated method stub

        if (INSTANCE == null) {

            synchronized (FileBasedConfigurationManagerImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FileBasedConfigurationManagerImpl();
                }
            }
        }
        return INSTANCE;
    }


    public static void resetInstance(){
        // TODO Auto-generated method stub
        INSTANCE = null;
    }

}