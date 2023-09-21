package com.scaler.lld.design.assignments.builder;

import java.util.Objects;

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
        DatabaseConfigurationBuilder obj;

        Builder() {
            this.obj = new DatabaseConfigurationBuilder();
        }
        public Builder databaseUrl(String databaseUrl) {
            obj.databaseUrl = databaseUrl;
            return this;
        }

        public Builder username(String username) {
            obj.username = username;
            return this;
        }
        public Builder password(String password) {
            obj.password = password;
            return this;
        }
        public Builder maxConnections(int maxConnections) {
            obj.maxConnections = maxConnections;
            return this;
        }

        public Builder enableCache(boolean enableCache) {
            obj.enableCache = enableCache;
            return this;
        }

        public Builder isReadOnly(boolean isReadOnly) {
            obj.isReadOnly = isReadOnly;
            return this;
        }

        public DatabaseConfigurationBuilder build() {
            return obj;
        }
    }
}