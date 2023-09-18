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

    public static class Builder {
        private String databaseUrl;
        private String username;
        private String password;
        private int maxConnections;
        private boolean enableCache;
        private boolean isReadOnly;

        public Builder() {
        }

        public DatabaseConfigurationBuilder build() {
            DatabaseConfigurationBuilder outerClassObj = new DatabaseConfigurationBuilder();
            outerClassObj.databaseUrl = databaseUrl;
            outerClassObj.username = username;
            outerClassObj.password = password;
            outerClassObj.maxConnections = maxConnections;
            outerClassObj.enableCache = enableCache;
            outerClassObj.isReadOnly = isReadOnly;
            return outerClassObj;
        }

        public Builder url(String databaseUrl) {
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

        public Builder readOnly(boolean readOnly) {
            isReadOnly = readOnly;
            return this;
        }
    }
}