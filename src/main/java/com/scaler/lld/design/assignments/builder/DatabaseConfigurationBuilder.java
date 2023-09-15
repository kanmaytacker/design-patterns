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
        private String databaseUrl;
        private String username;
        private String password;
        private int maxConnections;
        private boolean enableCache;
        private boolean isReadOnly;

        public Builder databaseUrl(String databaseUrl) {
            this.databaseUrl = databaseUrl;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder maxConnections(int maxConnections) {
            this.maxConnections = maxConnections;
            return this;
        }

        public Builder enableCache(boolean enableCache) {
            this.enableCache = enableCache;
            return this;
        }

        public Builder readOnly() {
            isReadOnly = true;
            return this;
        }
        public boolean isValid() {
            return true;
        }
        public DatabaseConfigurationBuilder build() {
            DatabaseConfigurationBuilder instance = new DatabaseConfigurationBuilder();
            instance.databaseUrl = databaseUrl;
            instance.username = username;
            instance.password = password;
            instance.maxConnections = maxConnections;
            instance.enableCache = enableCache;
            instance.isReadOnly = isReadOnly;
            return instance;
        }
    }
}