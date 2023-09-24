package com.scaler.lld.design.assignments.singleton;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static FileBasedConfigurationManager INSTANCE=null;

    private FileBasedConfigurationManagerImpl()
    {

    }

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
        T ans=null;
        String val=this.properties.getProperty(key);
        if(val!=null)
        ans=convert(val,type);
        return ans;
    }

    @Override
    public void setConfiguration(String key, String value) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'setConfiguration'");
        this.properties.setProperty(key,value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'setConfiguration'");
        this.properties.setProperty(key,(value+""));
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
        if(INSTANCE==null)
        {
            synchronized(FileBasedConfigurationManager.class)
            {
                if(INSTANCE==null)
                {
                    INSTANCE=new FileBasedConfigurationManagerImpl();
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