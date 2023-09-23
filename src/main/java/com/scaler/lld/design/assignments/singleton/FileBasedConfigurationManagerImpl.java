package com.scaler.lld.design.assignments.singleton;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {
    private static FileBasedConfigurationManagerImpl instance=null;
    private FileBasedConfigurationManagerImpl(){
    }
    @Override
    public String getConfiguration(String key) {
        return this.properties.getProperty(key);
        //throw new UnsupportedOperationException("Unimplemented method 'getConfiguration'");
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        if(instance!=null){
            String value=instance.properties.getProperty(key); //This retrieves the value
            if(value!=null)
                return convert(value,type);
            else
                return null;
        }
        else{
            throw new NullPointerException("Configuration Manager Instance is NULL");
        }
        //throw new UnsupportedOperationException("Unimplemented method 'getConfiguration'");

    }

    @Override
    public void setConfiguration(String key, String value) {
        this.properties.setProperty(key, value);
        //throw new UnsupportedOperationException("Unimplemented method 'setConfiguration'");

    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        properties.setProperty(key, String.valueOf((value)));
        //throw new UnsupportedOperationException("Unimplemented method 'setConfiguration'");

    }

    @Override
    public void removeConfiguration(String key) {
        properties.remove(key);
        //throw new UnsupportedOperationException("Unimplemented method 'removeConfiguration'");

    }

    @Override
    public void clear() {
        properties.clear();
        //throw new UnsupportedOperationException("Unimplemented method 'clear'");

    }

    public static FileBasedConfigurationManager getInstance() {
        if(instance==null){
            synchronized (FileBasedConfigurationManagerImpl.class){
                if(instance==null){
                    instance=new FileBasedConfigurationManagerImpl();
                }
            }
        }
        return instance;
    }

    public static void resetInstance() {
        instance=null;
    }

}