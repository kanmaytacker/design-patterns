package com.scaler.lld.design.assignments.singleton;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    // Step 3: static attribute
    static FileBasedConfigurationManager INSTANCE = null;

    // Step 1: Private constructor
    private FileBasedConfigurationManagerImpl()
    {
        super();
    }
    @Override
    public String getConfiguration(String key) {
        if(properties.containsKey(key)) {
            return properties.getProperty(key);
        }
        return null;
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        // TODO Auto-generated method stub
        if(properties.containsKey(key)) {
            return convert(properties.getProperty(key), type);
        }
        return null;
    }

    @Override
    public void setConfiguration(String key, String value) {

        properties.setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        // TODO Auto-generated method stub
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

    // Step 2: global access point for instance
    public static FileBasedConfigurationManager getInstance() {
         // Step 4: Double-checked locking
        if(INSTANCE == null)
        {
            synchronized (FileBasedConfigurationManagerImpl.class)
            {
                if(INSTANCE == null)
                {
                    INSTANCE = new FileBasedConfigurationManagerImpl();
                }
            }
        }

        return INSTANCE;
    }

    public static void resetInstance() {
        synchronized (FileBasedConfigurationManagerImpl.class)
        {
            INSTANCE = null;
        }
    }

}