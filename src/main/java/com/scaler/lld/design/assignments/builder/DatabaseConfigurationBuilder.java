package com.scaler.lld.design.assignments.builder;

@WithBuilder
public class DatabaseConfigurationBuilder {
    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

    //step 1:hide the constructor
    private DatabaseConfigurationBuilder(){

    }

    public static DBConfigBuilder BuildDBConfiguration(){
        return new DBConfigBuilder();
    }

    public static class DBConfigBuilder{
        private DatabaseConfigurationBuilder instance;

        public DBConfigBuilder( ){

            this.instance = new DatabaseConfigurationBuilder();
        }

        public DBConfigBuilder WithDatabaseUrl(String url){
            this.instance.databaseUrl = url;
            return this;
        }

        public DBConfigBuilder WithUsername(String usrname){
            this.instance.username = usrname;
            return this;
        }

        public DBConfigBuilder WithPassword(String passwd){
            this.instance.password = passwd;
            return this;
        }

        public DBConfigBuilder WithMaxConnections(int connections){
            this.instance.maxConnections = connections;
            return this;
        }

        public DBConfigBuilder enableCache(boolean canEnable){
            this.instance.enableCache = canEnable;
            return this;
        }

        public DBConfigBuilder isReadOnly(boolean isReadOnly){
            this.instance.isReadOnly = isReadOnly;
            return this;
        }

        public DatabaseConfigurationBuilder build(){
            return instance;
        }



    }

}