package com.scaler.lld.design.assignments.builder;

import lombok.Getter;
import lombok.Setter;

@WithBuilder
@Getter
public class DatabaseConfigurationBuilder {

    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;


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



        public Builder setDatabaseUrl(String databaseUrl) {
            this.databaseUrl = databaseUrl;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setMaxConnections(int maxConnections) {
            this.maxConnections = maxConnections;
            return this;
        }

        public Builder setEnableCache(boolean enableCache) {
            this.enableCache = enableCache;
            return this;
        }

        public Builder setReadOnly(boolean readOnly) {
            isReadOnly = readOnly;
            return this;
        }

        public DatabaseConfigurationBuilder build(){
           return new DatabaseConfigurationBuilder
                   (this.databaseUrl, this.username, this.password, this.maxConnections, this.enableCache, this.isReadOnly);
       }

    }
}