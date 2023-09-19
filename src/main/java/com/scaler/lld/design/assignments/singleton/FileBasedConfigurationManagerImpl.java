package com.scaler.lld.design.assignments.singleton;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {


    private FileBasedConfigurationManagerImpl()
    {

    }
    private static FileBasedConfigurationManager fileBasedConfigurationManager = null;
    @Override
    public String getConfiguration(String key) {
       return this.properties.getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        String value = this.properties.getProperty(key);
        if(value!=null && !"".equalsIgnoreCase(value))
        {
            return convert(value,type);
        }
        return null;
    }

    @Override
    public void setConfiguration(String key, String value) {
        this.properties.setProperty(key,value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        this.properties.setProperty(key, String.valueOf(value));

    }

    @Override
    public void removeConfiguration(String key) {
        this.properties.remove(key);
    }

    @Override
    public void clear() {
        this.properties.clear();
    }

    public static FileBasedConfigurationManager getInstance() {
       if(fileBasedConfigurationManager == null)
       {
           synchronized (FileBasedConfigurationManager.class)
           {
               if(fileBasedConfigurationManager == null)
               {
                   fileBasedConfigurationManager = new FileBasedConfigurationManagerImpl();
               }
           }
       }
        return fileBasedConfigurationManager;
    }

    public static void resetInstance() {
        fileBasedConfigurationManager = null;
    }

}