package com.scaler.lld.design.assignments.builder;

import lombok.Getter;
import lombok.Setter;

@WithBuilder

public class DatabaseConfigurationBuilder {

    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

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

    private DatabaseConfigurationBuilder(String databaseUrl, String username, String password, int maxConnections, boolean enableCache, boolean isReadOnly) {
            this.databaseUrl = databaseUrl;
            this.username = username;
            this.password = password;
            this.maxConnections = maxConnections;
            this.enableCache = enableCache;
            this.isReadOnly = isReadOnly;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    @Setter
    @Getter
    public static class Builder{

        private String databaseUrl;
        private String username;
        private String password;
        private int maxConnections;
        private boolean enableCache;
        private boolean isReadOnly;

        public void setDatabaseUrl(String databaseUrl) {
            this.databaseUrl = databaseUrl;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setMaxConnections(int maxConnections) {
            this.maxConnections = maxConnections;
        }

        public void setEnableCache(boolean enableCache) {
            this.enableCache = enableCache;
        }

        public void setReadOnly(boolean readOnly) {
            isReadOnly = readOnly;
        }

        public DatabaseConfigurationBuilder build(){
           return new DatabaseConfigurationBuilder
                   (this.databaseUrl, this.username, this.password, this.maxConnections, this.enableCache, this.isReadOnly);
       }

    }
}