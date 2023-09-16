package com.scaler.lld.design.assignments.builder;

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
    static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String databaseUrl;
        private String username;
        private String password;
        private int maxConnections;
        private boolean enableCache;
        private boolean isReadOnly;

        public Builder setDatabaseUrl(String databaseUrl) {
            this.databaseUrl = databaseUrl;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setMaxConnections(int maxConnections) {
            this.maxConnections = maxConnections;
            return this;
        }

        public Builder setEnableCache(boolean enableCache) {
            this.enableCache = enableCache;
            return this;
        }

        public Builder setReadOnly(boolean readOnly) {
            isReadOnly = readOnly;
            return this;
        }

        public DatabaseConfigurationBuilder build(){
            DatabaseConfigurationBuilder dbBuilder = new DatabaseConfigurationBuilder();
            dbBuilder.databaseUrl = this.databaseUrl;
            dbBuilder.enableCache = this.enableCache;
            dbBuilder.isReadOnly = this.isReadOnly;
            dbBuilder.password = this.password;
            dbBuilder.maxConnections = this.maxConnections;
            dbBuilder.username = this.username;
            return dbBuilder;
        }
    }

}