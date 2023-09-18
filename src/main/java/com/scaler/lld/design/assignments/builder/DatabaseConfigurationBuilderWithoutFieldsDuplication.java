package com.scaler.lld.design.assignments.builder;

@WithBuilder
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

        public DatabaseConfiguration build() {
            //return new object instead of "instance" variable due to immutability advantage.
            return new DatabaseConfiguration(instance.databaseUrl, instance.username, instance.password,
                    instance.maxConnections, instance.enableCache, instance.isReadOnly);
        }

        public Builder setDatabaseUrl(String databaseUrl) {
            instance.databaseUrl = databaseUrl;
            return this;
        }

        public Builder setUsername(String username) {
            instance.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            instance.password = password;
            return this;
        }

        public Builder setMaxConnections(int maxConnections) {
            instance.maxConnections = maxConnections;
            return this;
        }

        public Builder setEnableCache(boolean enableCache) {
            instance.enableCache = enableCache;
            return this;
        }

        public Builder setReadOnly(boolean readOnly) {
            instance.isReadOnly = readOnly;
            return this;
        }
    }
}