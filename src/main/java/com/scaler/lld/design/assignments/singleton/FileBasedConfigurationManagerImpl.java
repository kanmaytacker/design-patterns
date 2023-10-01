package com.scaler.lld.design.assignments.singleton;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private FileBasedConfigurationManagerImpl(){

    }

    private static FileBasedConfigurationManagerImpl confManagerObj = null;

    @Override
    public String getConfiguration(String key) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getConfiguration'");

        return this.properties.getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getConfiguration'");
        T result = null;
        String configuration = this.properties.getProperty(key);
        if(configuration!=null){
            result = convert(configuration, type);
        }

        return result;
    }

    @Override
    public void setConfiguration(String key, String value) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'setConfiguration'");
        this.properties.setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'setConfiguration'");
        this.properties.setProperty(key, String.valueOf(value));

    }

    @Override
    public void removeConfiguration(String key) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'removeConfiguration'");
        this.properties.remove(key);
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'clear'");
        this.properties.clear();
    }

    public static FileBasedConfigurationManager getInstance() {
        // TODO Auto-generated method stub
        if(confManagerObj==null){
            synchronized (FileBasedConfigurationManagerImpl.class){
                if(confManagerObj==null){
                    confManagerObj = new FileBasedConfigurationManagerImpl();
                }
            }
        }
        return confManagerObj;
    }

    public static void resetInstance() {
        // TODO Auto-generated method stub
        confManagerObj = null;
    }

}