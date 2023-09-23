package com.scaler.lld.design.assignments.builder;

@WithBuilder
public class DatabaseConfigurationBuilder {
    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;
    public static Builder builder(){ //static builder method
        return new Builder();
    }
    private DatabaseConfigurationBuilder(){} //Private constructor
    public static class Builder{

        DatabaseConfigurationBuilder obj;
        public Builder(){
            obj=new DatabaseConfigurationBuilder();
        }
        public Builder setDatabaseUrl(String databaseUrl) {
            obj.databaseUrl = databaseUrl; return this;
        }

        public Builder setUsername(String username) {
            obj.username = username; return this;
        }

        public Builder setPassword(String password) {
            obj.password = password; return this;
        }

        public Builder setMaxConnections(int maxConnections) {
            obj.maxConnections = maxConnections; return this;
        }

        public Builder setEnableCache(boolean enableCache) {
            obj.enableCache = enableCache; return this;
        }

        public Builder setReadOnly(boolean readOnly) {
            obj.isReadOnly = readOnly; return this;
        }
        public DatabaseConfigurationBuilder build(){
            return obj;
        }

    }



}