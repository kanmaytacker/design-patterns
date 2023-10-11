package com.scaler.lld.design.assignments.builder;

import lombok.Getter;

@WithBuilder
@Getter
public class DatabaseConfigurationBuilder {
    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

    public DB_builer Builder()
    {
        return new DB_builer();
    }

    // Step 1: create static inner class
    public static class DB_builer
    {
        // Step 2: copy all fields into builder class
        private DatabaseConfigurationBuilder dbConfig;

        public DB_builer()
        {
            this.dbConfig = new DatabaseConfigurationBuilder();
        }

        // Step 2:
        // expose setter (fluent interfaces)


        public DB_builer setDatabaseUrl(String databaseUrl) {
            this.dbConfig.databaseUrl = databaseUrl;
            return this;
        }

        public DB_builer setEnableCache(boolean enableCache) {
            this.dbConfig.enableCache = enableCache;
            return this;
        }

        public DB_builer setMaxConnections(int maxConnections) {
            this.dbConfig.maxConnections = maxConnections;
            return this;
        }

        public DB_builer setPassword(String password) {
            this.dbConfig.password = password;
            return this;
        }

        public DB_builer setReadOnly(boolean readOnly) {
            this.dbConfig.isReadOnly = readOnly;
            return this;
        }

        public DB_builer setUsername(String username) {
            this.dbConfig.username = username;
            return this;
        }

        // Step 4: build method
        public DatabaseConfigurationBuilder build()
        {
            DatabaseConfigurationBuilder db = new DatabaseConfigurationBuilder();

            db.databaseUrl = dbConfig.databaseUrl;
            db.isReadOnly = dbConfig.isReadOnly;
            db.enableCache = dbConfig.enableCache;
            db.maxConnections = dbConfig.maxConnections;
            db.password = dbConfig.password;
            db.username = dbConfig.username;

            return db;
        }
    }
}