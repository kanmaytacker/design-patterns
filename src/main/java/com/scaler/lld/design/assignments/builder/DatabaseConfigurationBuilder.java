package com.scaler.lld.design.assignments.builder;

@WithBuilder
public class DatabaseConfigurationBuilder {
    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

    /// immutable
    private  DatabaseConfigurationBuilder() {
        
    }

    //// friend class
    public static class Builder {

        private String databaseUrl;
        private String username;
        private String password;
        private int maxConnections;
        private boolean enableCache;
        private boolean isReadOnly;
        
      private   Builder(){
        
      } 


        public Builder setDatabaseUrl(String databaseUrl) {
            this.databaseUrl = databaseUrl;
            return this;
        }

        public Builder setUsernameAndPassword(String username, String password) {
            this.username = username;
            this.password = password;
            return this;
        }

        public Builder setMaxConnections(int maxConnections) {
            this.maxConnections = maxConnections;
            return this;
        }

        public Builder isEnableCache(boolean enableCache) {
            this.enableCache = enableCache;
            return this;
        }

        public Builder isReadOnly(boolean isReadOnly) {
            this.isReadOnly = isReadOnly;
            return this;
        }

        public DatabaseConfigurationBuilder build() {
            DatabaseConfigurationBuilder obj =new DatabaseConfigurationBuilder();
            obj.databaseUrl=this.databaseUrl;
            obj.username=this.username;
            obj.password=this.password;
            obj.maxConnections=this.maxConnections;
            obj.enableCache=this.enableCache;
            obj.isReadOnly=this.isReadOnly;
            return obj;
        }

    }

}
