package com.scaler.lld.design.assignments.builder;

//@WithBuilder
public class DatabaseConfigurationBuilderWithoutFieldsDuplication {
    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

    private DatabaseConfigurationBuilderWithoutFieldsDuplication() {
    }

    public static class Builder {
        private DatabaseConfigurationBuilderWithoutFieldsDuplication instance;
        public Builder() {
            instance = new DatabaseConfigurationBuilderWithoutFieldsDuplication();
        }

        public DatabaseConfigurationBuilderWithoutFieldsDuplication build() {
            //return new object instead of "instance" variable due to immutability advantage.
            DatabaseConfigurationBuilderWithoutFieldsDuplication outerClassObj = new DatabaseConfigurationBuilderWithoutFieldsDuplication();
            outerClassObj.databaseUrl = instance.databaseUrl;
            outerClassObj.username = instance.username;
            outerClassObj.password = instance.password;
            outerClassObj.maxConnections = instance.maxConnections;;
            outerClassObj.enableCache = instance.enableCache;
            outerClassObj.isReadOnly = instance.isReadOnly;
            return outerClassObj;
        }

        public Builder url(String databaseUrl) {
            instance.databaseUrl = databaseUrl;
            return this;
        }

        public Builder username(String username) {
            instance.username = username;
            return this;
        }

        public Builder password(String password) {
            instance.password = password;
            return this;
        }

        public Builder maxConnections(int maxConnections) {
            instance.maxConnections = maxConnections;
            return this;
        }

        public Builder enableCache(boolean enableCache) {
            instance.enableCache = enableCache;
            return this;
        }

        public Builder readOnly(boolean readOnly) {
            instance.isReadOnly = readOnly;
            return this;
        }
    }
}