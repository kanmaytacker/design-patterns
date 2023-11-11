package com.scaler.lld.design.assignments.singleton;

public class MyConfigurationManager  extends FileBasedConfigurationManager{

    private static MyConfigurationManager myConfigurationManager = null;

    private MyConfigurationManager()
    {

    }

    public static MyConfigurationManager getInstance()
    {
        if(myConfigurationManager == null)
        {
            synchronized (MyConfigurationManager.class)
            {
                if(myConfigurationManager == null)
                {
                    myConfigurationManager = new MyConfigurationManager();
                }
            }
        }
        return myConfigurationManager;
    }

    public static void resetInstance()
    {
        myConfigurationManager = null;
    }

    @Override
    public String getConfiguration(String key) {
        return properties.getProperty(key);
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
        properties.setProperty(key,value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        this.properties.setProperty(key, String.valueOf(value));
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
