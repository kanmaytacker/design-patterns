package com.scaler.lld.design.assignments.builder;

@WithBuilder
public class DatabaseConfigurationBuilder {
    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;
    private DatabaseConfigurationBuilder() {}

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private DatabaseConfigurationBuilder databaseConfigurationBuilder;

        private Builder() {
            databaseConfigurationBuilder = new DatabaseConfigurationBuilder();
        }

        public Builder databaseUrl(String databaseUrl) {
            this.databaseConfigurationBuilder.databaseUrl = databaseUrl;
            return this;
        }

        public Builder username(String username) {
            this.databaseConfigurationBuilder.username = username;
            return this;
        }

        public Builder password(String password) {
            this.databaseConfigurationBuilder.password = password;
            return this;
        }

        public Builder maxConnections(int maxConnections) {
            this.databaseConfigurationBuilder.maxConnections = maxConnections;
            return this;
        }

        public Builder enableCache(boolean enableCache) {
            this.databaseConfigurationBuilder.enableCache = enableCache;
            return this;
        }

        public Builder readOnly() {
            databaseConfigurationBuilder.isReadOnly = true;
            return this;
        }
        public boolean isValid() {
            return true;
        }
        public DatabaseConfigurationBuilder build() {
            DatabaseConfigurationBuilder instance = new DatabaseConfigurationBuilder();
            instance.databaseUrl = databaseConfigurationBuilder.databaseUrl;
            instance.username = databaseConfigurationBuilder.username;
            instance.password = databaseConfigurationBuilder.password;
            instance.maxConnections = databaseConfigurationBuilder.maxConnections;
            instance.enableCache = databaseConfigurationBuilder.enableCache;
            instance.isReadOnly = databaseConfigurationBuilder.isReadOnly;
            return instance;
        }
    }
}