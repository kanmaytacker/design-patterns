package com.scaler.lld.design.assignments.builder;

@WithBuilder
public class DatabaseConfigurationBuilder {
    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;
    private DatabaseConfigurationBuilder(DBConfigureBuilder dbConfigurationBuilder){
        this.databaseUrl = dbConfigurationBuilder.databaseUrl;
        this.username = dbConfigurationBuilder.username;
        this.password = dbConfigurationBuilder.password;
        this.maxConnections = dbConfigurationBuilder.maxConnections;
        this.enableCache = dbConfigurationBuilder.enableCache;
        this.isReadOnly = dbConfigurationBuilder.isReadOnly;
    }

    public static DBConfigureBuilder builder(){
        return new DBConfigureBuilder();
    }

    public static class DBConfigureBuilder{
        private String databaseUrl;
        private String username;
        private String password;
        private int maxConnections;
        private boolean enableCache;
        private boolean isReadOnly;

        public String getDatabaseUrl() {
            return databaseUrl;
        }

        public DBConfigureBuilder setDatabaseUrl(String databaseUrl) {
            this.databaseUrl = databaseUrl;
            return this;
        }

        public String getUsername() {
            return username;
        }

        public DBConfigureBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public String getPassword() {
            return password;
        }

        public DBConfigureBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public int getMaxConnections() {
            return maxConnections;
        }

        public DBConfigureBuilder setMaxConnections(int maxConnections) {
            this.maxConnections = maxConnections;
            return this;
        }

        public boolean isEnableCache() {
            return enableCache;
        }

        public DBConfigureBuilder setEnableCache(boolean enableCache) {
            this.enableCache = enableCache;
            return this;
        }

        public boolean isReadOnly() {
            return isReadOnly;
        }

        public DBConfigureBuilder setReadOnly(boolean readOnly) {
            isReadOnly = readOnly;
            return this;
        }
        public DatabaseConfigurationBuilder build(){
            return new DatabaseConfigurationBuilder(this);
        }
    }
}