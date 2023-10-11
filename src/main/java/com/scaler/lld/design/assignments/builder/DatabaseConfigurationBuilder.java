package com.scaler.lld.design.assignments.builder;

@WithBuilder
public class DatabaseConfigurationBuilder {
    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

    private DatabaseConfigurationBuilder() {
    }

    public Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private DatabaseConfigurationBuilder databaseConfigurationBuilder;

        Builder() {
            databaseConfigurationBuilder = new DatabaseConfigurationBuilder();
        }

        public Builder setDatabaseUrl(String databaseUrl) {
            this.databaseConfigurationBuilder.databaseUrl = databaseUrl;
            return this;
        }

        public Builder setUsername(String username) {
            this.databaseConfigurationBuilder.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.databaseConfigurationBuilder.password = password;
            return this;

        }

        public Builder setMaxConnections(int maxConnections) {
            this.databaseConfigurationBuilder.maxConnections = maxConnections;
            return this;
        }

        public Builder setEnableCache(boolean enableCache) {
            this.databaseConfigurationBuilder.enableCache = enableCache;
            return this;

        }

        public Builder setReadOnly(boolean isReadOnly) {
            this.databaseConfigurationBuilder.isReadOnly = isReadOnly;
            return this;
        }

        public DatabaseConfigurationBuilder build(){
            DatabaseConfigurationBuilder db=new DatabaseConfigurationBuilder();
            db.databaseUrl=this.databaseConfigurationBuilder.databaseUrl;
            db.enableCache=this.databaseConfigurationBuilder.enableCache;
            db.isReadOnly=this.databaseConfigurationBuilder.isReadOnly;
            db.maxConnections=this.databaseConfigurationBuilder.maxConnections;
            db.password=this.databaseConfigurationBuilder.password;
            db.username=this.databaseConfigurationBuilder.username;
            return db;
        }
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public boolean isEnableCache() {
        return enableCache;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }
}