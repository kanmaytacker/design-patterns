package com.scaler.lld.design.assignments.singleton;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static FileBasedConfigurationManager fileBasedConfigurationManager;

    private FileBasedConfigurationManagerImpl(){
    }

    @Override
    public String getConfiguration(String key) {
        // TODO Auto-generated method stub
        if(properties.containsKey(key)) return properties.getProperty(key);
        return null;
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        // TODO Auto-generated method stub
        String value=properties.getProperty(key);
        T ans=null;
        if(value!=null){
            ans=convert(value,type);
        }
        return ans;
    }

    @Override
    public void setConfiguration(String key, String value) {
        // TODO Auto-generated method stub
        properties.setProperty(key,value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        // TODO Auto-generated method stub
        properties.setProperty(key,(String)value);
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

    public static FileBasedConfigurationManager getInstance() {
        // TODO Auto-generated method stub
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
        fileBasedConfigurationManager=null;
    }

}