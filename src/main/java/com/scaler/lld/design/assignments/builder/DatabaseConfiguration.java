package com.scaler.lld.design.assignments.builder;

import lombok.Data;
import lombok.Getter;
import lombok.With;

@WithBuilder
public class DatabaseConfiguration {

    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

    public DatabaseConfiguration(String databaseUrl, String username, String password, int maxConnections, boolean enableCache, boolean isReadOnly) {
        this.databaseUrl = databaseUrl;
        this.username = username;
        this.password = password;
        this.maxConnections = maxConnections;
        this.enableCache = enableCache;
        this.isReadOnly = isReadOnly;
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

    public static DatabaseConfigurationBuilder builder(){
        return new DatabaseConfigurationBuilder();
    }

    public static class DatabaseConfigurationBuilder{
        private String databaseUrl;
        private String username;
        private String password;
        private int maxConnections;
        private boolean enableCache;
        private boolean isReadOnly;

        public DatabaseConfigurationBuilder setDatabaseUrl(String databaseUrl) {
            this.databaseUrl = databaseUrl;
            return this;
        }

        public DatabaseConfigurationBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public DatabaseConfigurationBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public DatabaseConfigurationBuilder setMaxConnections(int maxConnections) {
            this.maxConnections = maxConnections;
            return this;
        }

        public DatabaseConfigurationBuilder setEnableCache(boolean enableCache) {
            this.enableCache = enableCache;
            return this;
        }

        public DatabaseConfigurationBuilder setReadOnly(boolean readOnly) {
            isReadOnly = readOnly;
            return this;
        }

        public DatabaseConfiguration build(){
            DatabaseConfiguration config = new DatabaseConfiguration(databaseUrl, username, password, maxConnections, enableCache, isReadOnly);
//            databaseUrl = null; username = null; password=null; maxConnections=0; enableCache = false; isReadOnly = false;
            return config;
        }
    }
}