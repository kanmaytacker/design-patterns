package com.scaler.lld.design.assignments.builder;

import com.scaler.lld.design.creational.builder.database.Database;

@WithBuilder
public class DatabaseConfigurationBuilder {

    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

    private DatabaseConfigurationBuilder(){
    }



    public static Builder builder(){
        return new Builder();
    }

    public  static class Builder{
        //DatabaseConfiguration databaseConfig ;
        private String databaseUrl;
        private String username;
        private String password;
        private int maxConnections;
        private boolean enableCache;
        private boolean isReadOnly;

        public Builder(){
            // databaseConfig = new DatabaseConfiguration();
        }




        public Builder setReadOnly(boolean readOnly) {
            isReadOnly = readOnly;
            return this;
        }

        public Builder setEnableCache(boolean enableCache) {
            this.enableCache = enableCache;
            return this;
        }

        public Builder setMaxConnections(int maxConnections) {
            this.maxConnections = maxConnections;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setDatabaseUrl(String databaseUrl) {
            this.databaseUrl = databaseUrl;
            return this;
        }

        public DatabaseConfigurationBuilder build(){
            DatabaseConfigurationBuilder databaseConfigurationBuilder = new DatabaseConfigurationBuilder();
            databaseConfigurationBuilder.databaseUrl = this.databaseUrl;
            databaseConfigurationBuilder.enableCache = this.enableCache;
            databaseConfigurationBuilder.isReadOnly = this.isReadOnly;
            databaseConfigurationBuilder.maxConnections = this.maxConnections;
            databaseConfigurationBuilder.password = this.password;
            databaseConfigurationBuilder.username = this.username;



            return  databaseConfigurationBuilder;
        }


    }

}