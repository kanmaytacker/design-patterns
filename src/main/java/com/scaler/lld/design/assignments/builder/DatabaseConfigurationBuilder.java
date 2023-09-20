package com.scaler.lld.design.assignments.builder;

import lombok.Getter;

@WithBuilder
@Getter
public class DatabaseConfigurationBuilder {

    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

    private DatabaseConfigurationBuilder(){
    }

    public static DBConfigBuilder builder(){
        return new DBConfigBuilder();
    }

    public static class DBConfigBuilder {
        public String databaseUrl;
        private String username;
        private String password;
        private int maxConnections;
        private boolean enableCache;
        private boolean isReadOnly;

        // Creating fluent interfaces for setter
        public DBConfigBuilder setDatabaseUrl(String databaseUrl){
            this.databaseUrl = databaseUrl;
            return this;
        }
        public DBConfigBuilder setUsername(String username){
            this.username = username;
            return this;
        }
        public DBConfigBuilder setPassword(String password){
            this.password = password;
            return this;
        }
        public DBConfigBuilder setMaxConnections(int maxConnections){
            this.maxConnections = maxConnections;
            return this;
        }
        public DBConfigBuilder setEnableCache(boolean enableCache){
            this.enableCache = enableCache;
            return this;
        }
        public DBConfigBuilder setIsReadOnly(boolean isReadOnly){
            this.isReadOnly = isReadOnly;
            return this;
        }

        public DatabaseConfigurationBuilder build(){
//            if (!isValid()){
//                throw new IllegalArgumentException("Ivalid Database Configuration");
//            }
            DatabaseConfigurationBuilder databaseConfigurationBuilder = new DatabaseConfigurationBuilder();
            databaseConfigurationBuilder.databaseUrl = this.databaseUrl;
            databaseConfigurationBuilder.username = this.username;
            databaseConfigurationBuilder.password = this.password;
            databaseConfigurationBuilder.maxConnections = this.maxConnections;
            databaseConfigurationBuilder.enableCache = this.enableCache;
            databaseConfigurationBuilder.isReadOnly = this.isReadOnly;
            return databaseConfigurationBuilder;
        }

//        public Boolean isValid(){
//            if (this.databaseUrl == null){
//                return false;
//            }
//            return true;
//        }
    }
}