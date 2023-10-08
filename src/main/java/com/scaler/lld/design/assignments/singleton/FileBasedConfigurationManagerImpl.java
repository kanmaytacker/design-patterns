package com.scaler.lld.design.assignments.singleton;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {
    private FileBasedConfigurationManagerImpl(){
        super();
    }
    public static FileBasedConfigurationManagerImpl INSTANCE=null;
    @Override
    public String getConfiguration(String key) {
        // TODO Auto-generated method stub
        if(INSTANCE!=null){
            return INSTANCE.properties.getProperty(key);
        }
        else{
            throw new NullPointerException("Configuration Manager Instance is NULL");
        }
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
        if(INSTANCE!=null) {
            INSTANCE.properties.setProperty(key, value);
        }
        else{
            throw new NullPointerException("Configuration Manager Instance is NULL");
        }
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        // TODO Auto-generated method stub
        if(INSTANCE!=null) {
            INSTANCE.properties.setProperty(key,value.toString());
        }
        else{
            throw new NullPointerException("Configuration Manager Instance is NULL");
        }
    }

    @Override
    public void removeConfiguration(String key) {
        // TODO Auto-generated method stub
        if(INSTANCE!=null) {
            INSTANCE.properties.remove(key);
        }
        else{
            throw new NullPointerException("Configuration Manager Instance is NULL");
        }
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        if(INSTANCE!=null) {
            INSTANCE.properties.clear();
        }
        else{
            throw new NullPointerException("Configuration Manager Instance is NULL");
        }
    }

    public static FileBasedConfigurationManager getInstance() {
        // TODO Auto-generated method stub
        if(INSTANCE==null) {
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
        INSTANCE=null;
    }

}