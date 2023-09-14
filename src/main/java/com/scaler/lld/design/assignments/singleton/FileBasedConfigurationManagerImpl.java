package com.scaler.lld.design.assignments.singleton;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {
    private static FileBasedConfigurationManagerImpl INSTANCE;
    private static boolean isReset;

    private FileBasedConfigurationManagerImpl(){}

    public static FileBasedConfigurationManagerImpl getInstance(){
        if (INSTANCE == null || isReset){
            synchronized (FileBasedConfigurationManagerImpl.class){
                if (INSTANCE == null || isReset){
                    INSTANCE = new FileBasedConfigurationManagerImpl();
                }
            }
        }
        isReset = false;
        return INSTANCE;
    }

    public static void resetInstance(){
        isReset = true;
        getInstance();
    }

    @Override
    public String getConfiguration(String key) {
        if (properties.containsKey(key))
            return properties.getProperty(key);

        return null;
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        if (properties.containsKey(key)) {
            Object data = properties.getProperty(key);

            if(type.getName() ==  "java.lang.Integer")
                return type.cast(Integer.parseInt(data.toString()));

            return type.cast(data);
        }

        return null;
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
}