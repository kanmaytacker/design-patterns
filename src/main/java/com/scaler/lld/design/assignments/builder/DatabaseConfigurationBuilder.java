package com.scaler.lld.design.assignments.builder;

@WithBuilder
public class DatabaseConfigurationBuilder {

    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

    public static class DatabaseBuilder
    {
        private String databaseUrl;
        private String username;
        private String password;
        private int maxConnections;
        private boolean enableCache;
        private boolean isReadOnly;

        public DatabaseConfigurationBuilder build() {
            DatabaseConfigurationBuilder database = new DatabaseConfigurationBuilder();

            database.username = this.username;
            database.password = this.password;
            database.databaseUrl = this.databaseUrl;
            database.maxConnections = this.maxConnections;
            database.enableCache = this.enableCache;
            database.isReadOnly = this.isReadOnly;
            return database;
        }


        public DatabaseBuilder enableCache(boolean enableCache)
        {
            this.enableCache = enableCache;
            return this;
        }

        public DatabaseBuilder isReadOnly(boolean isReadOnly)
        {
            this.isReadOnly = isReadOnly;
            return this;
        }
        public DatabaseBuilder maxConnections(int maxConnections)
        {
            this.maxConnections = maxConnections;
            return this;
        }
        public DatabaseBuilder databaseUrl(String dbURL)
        {
            this.databaseUrl = dbURL;
            return this;
        }

        public DatabaseBuilder username(String username)
        {
            this.username = username;
            return this;
        }

        public DatabaseBuilder password(String password)
        {
            this.password = password;
            return this;
        }
    }

}