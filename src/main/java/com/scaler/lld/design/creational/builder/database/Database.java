package com.scaler.lld.design.creational.builder.database;

import lombok.Getter;

@Getter
public class Database {
    private String name;
    private String host;
    private int port;
    private DatabaseType type;

    // Step 1 - Hide the constructor
    private Database() {
    }

    // Add a static method to get the builder object
    public static DatabaseBuilder builder() {
        return new DatabaseBuilder();
    }
    
    // Step 2 - Create a static inner class with same fields as the outer class
    public static class DatabaseBuilder {
        Database database;

        public DatabaseBuilder() {
            database = new Database();
        }


        // Step 3 - Create fluent interfaces for setter
        public DatabaseBuilder withName(String name) {
            database.name = name;
            return this;
        }

        public DatabaseBuilder withUrl(String host, int port) {
            database.host = host;
            database.port = port;
            return this;
        }

        public DatabaseBuilder mysql() {
            database.type = DatabaseType.MYSQL;
            return this;
        }

        // Step 4 - Create a build method to return the outer class object
        public Database build() {

            if (!isValid()){
                throw new IllegalArgumentException("Invalid database configuration");
            }

            Database actualDatabase = new Database();
            actualDatabase.name = database.name;
            actualDatabase.host = database.host;
            actualDatabase.port = database.port;
            actualDatabase.type = database.type;
            return database;
        }

        // Step 5 - Add a validation method
        public Boolean isValid() {
            if (database.name == null) {
                return false;
            }
            return true;
        }
    }
    
}
