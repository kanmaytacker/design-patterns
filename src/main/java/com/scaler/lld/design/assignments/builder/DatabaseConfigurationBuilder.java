package com.scaler.lld.design.assignments.builder;

import lombok.Setter;

@WithBuilder
public class DatabaseConfigurationBuilder {

    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

//    public DatabaseConfiguration(String databaseUrl, String username, String password, int maxConnections, boolean enableCache, boolean isReadOnly) {
//        this.databaseUrl = databaseUrl;
//        this.username = username;
//        this.password = password;
//        this.maxConnections = maxConnections;
//        this.enableCache = enableCache;
//        this.isReadOnly = isReadOnly;
//    }

    private DatabaseConfigurationBuilder(){

    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
         private DatabaseConfigurationBuilder builder;

         Builder(){
             builder=new DatabaseConfigurationBuilder();
         }



       public DatabaseConfigurationBuilder build(){
           DatabaseConfigurationBuilder database=new DatabaseConfigurationBuilder();
           database.databaseUrl=builder.databaseUrl;
           database.username=builder.username;
           database.password=builder.password;
           database.maxConnections=builder.maxConnections;
           database.enableCache=builder.enableCache;
           database.isReadOnly=builder.isReadOnly;
           builder=new DatabaseConfigurationBuilder();
           return database;
       }


        public Builder setDatabaseUrl(String databaseUrl) {
            builder.databaseUrl=databaseUrl;
            return this;
        }

        public Builder setUsername(String username) {
            builder.username=username;
            return this;
        }

        public Builder setPassword(String password) {
            builder.password=password;
            return this;
        }

        public Builder getMaxConnections(int maxConnections) {
            builder.maxConnections=maxConnections;
            return this;
        }

        public Builder isEnableCache(boolean enableCache) {
            builder.enableCache=enableCache;
            return this;
        }

        public Builder isReadOnly(boolean isReadOnly) {
            builder.isReadOnly=isReadOnly;
            return this;
        }


    }
}