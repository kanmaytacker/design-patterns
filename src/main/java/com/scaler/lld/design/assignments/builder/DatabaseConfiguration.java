package com.scaler.lld.design.assignments.builder;

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
}