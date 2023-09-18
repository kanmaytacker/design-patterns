package com.scaler.lld.design.assignments.singleton;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    @Override
    public String getConfiguration(String key) {
        // TODO Auto-generated method stub
        return properties.getProperty(key);
//        throw new UnsupportedOperationException("Unimplemented method 'getConfiguration'");
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        // TODO Auto-generated method stub
        String value = getConfiguration(key);
        if(value == null) return null;
        return convert(value, type);
//        throw new UnsupportedOperationException("Unimplemented method 'getConfiguration'");
    }

    @Override
    public void setConfiguration(String key, String value) {
        // TODO Auto-generated method stub
        properties.setProperty(key, value);
//        throw new UnsupportedOperationException("Unimplemented method 'setConfiguration'");
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        // TODO Auto-generated method stub
        properties.setProperty(key, String.valueOf(value));
//        throw new UnsupportedOperationException("Unimplemented method 'setConfiguration'");
    }

    @Override
    public void removeConfiguration(String key) {
        // TODO Auto-generated method stub
        properties.remove(key);
//        throw new UnsupportedOperationException("Unimplemented method 'removeConfiguration'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        properties.clear();
//        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    private static FileBasedConfigurationManager _thisRef;
    private FileBasedConfigurationManagerImpl(){}
    public static FileBasedConfigurationManager getInstance() {
        // TODO Auto-generated method stub
        if(_thisRef == null){
            synchronized (FileBasedConfigurationManagerImpl.class){
                if(_thisRef == null){
                    _thisRef = new FileBasedConfigurationManagerImpl();
                }
            }
        }
        return _thisRef;
    }

    public static void resetInstance() {
        // TODO Auto-generated method stub
        _thisRef = null;
    }

}