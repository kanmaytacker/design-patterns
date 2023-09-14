package com.scaler.lld.design.assignments.builder;

import java.util.Objects;

@WithBuilder
public class DatabaseConfigurationBuilder {

    private String databaseUrl;
    private String username ;
    private String password ;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

    private DatabaseConfigurationBuilder() {


    }


    //DatabaseConfigurationBuilderTest
    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract(value = " -> new", pure = true)
    public static DatabaseConfigurationBuilderTest builder() {
        return new DatabaseConfigurationBuilderTest();
    }
    public static class DatabaseConfigurationBuilderTest{
       private String databaseUrl;
       private String username;
       private String password;
       private int maxConnections;
       private boolean enableCache;
       private boolean isReadOnly;


       public DatabaseConfigurationBuilderTest databaseUrl(String databaseUrl) {
           Objects.requireNonNull(databaseUrl, "databaseUrl cannot be null");
           this.databaseUrl = databaseUrl;
           return this;
       }

       public DatabaseConfigurationBuilderTest username(String username) {
           Objects.requireNonNull(username, "username cannot be null");
           this.username = username;
           return this;
       }

       public DatabaseConfigurationBuilderTest password(String password) {
           Objects.requireNonNull(password, "password cannot be null");
           this.password = password;
           return this;
       }

       public DatabaseConfigurationBuilderTest maxConnections(int maxConnections) {
           this.maxConnections = maxConnections;
           return this;
       }

       public DatabaseConfigurationBuilderTest enableCache(boolean enableCache) {
           this.enableCache = enableCache;
           return this;
       }

       public DatabaseConfigurationBuilderTest isReadOnly(boolean isReadOnly) {
           this.isReadOnly = isReadOnly;
           return this;
       }

       public DatabaseConfigurationBuilder build() {

            DatabaseConfigurationBuilder config = new DatabaseConfigurationBuilder();
            config.databaseUrl = this.databaseUrl;
            config.username = this.username;
            config.password = this.password;
            config.maxConnections = this.maxConnections;
            config.enableCache = this.enableCache;
            config.isReadOnly = this.isReadOnly;

            if (config == null){
                throw new IllegalStateException("not valid");
            }
            return config;
       }

   }

}
