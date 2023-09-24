package com.scaler.lld.design.assignments.builder;

@WithBuilder
public class  DatabaseConfigurationBuilder {

    // NO SETTER IN OUTER CLASS

    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

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

    public static Builder builder()
    {
        return new Builder();
    }




    public static class Builder
    {
       private DatabaseConfigurationBuilder obj;

        public Builder() {
            obj = new DatabaseConfigurationBuilder();
        }

        public Builder setDatabaseUrl(String databaseUrl) {
            this.obj.databaseUrl = databaseUrl;
            return this;
        }

        public Builder setUsername(String username) {
            this.obj.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.obj.password = password;
            return this;

        }

        public Builder setMaxConnections(int maxConnections) {
            this.obj.maxConnections = maxConnections;
            return this;
        }

        public Builder setEnableCache(boolean enableCache) {
            this.obj.enableCache = enableCache;
            return this;

        }

        public Builder setReadOnly(boolean isReadOnly) {
            this.obj.isReadOnly = isReadOnly;
            return this;
        }

        public DatabaseConfigurationBuilder build(){
            DatabaseConfigurationBuilder db=new DatabaseConfigurationBuilder();
            db.databaseUrl=this.obj.databaseUrl;
            db.enableCache=this.obj.enableCache;
            db.isReadOnly=this.obj.isReadOnly;
            db.maxConnections=this.obj.maxConnections;
            db.password=this.obj.password;
            db.username=this.obj.username;
            return db;
        }






    }

}