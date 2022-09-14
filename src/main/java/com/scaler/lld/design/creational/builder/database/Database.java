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
        private String name;
        private String host;
        private int port;
        private DatabaseType type;


        // Step 3 - Create fluent interfaces for setter
        public DatabaseBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DatabaseBuilder withUrl(String host, int port) {
            this.host = host;
            this.port = port;
            return this;
        }

        public DatabaseBuilder mysql() {
            this.type = DatabaseType.MYSQL;
            return this;
        }

        // Step 4 - Create a build method to return the outer class object
        public Database build() {

            if (!isValid()){
                throw new IllegalArgumentException("Invalid database configuration");
            }

            Database database = new Database();
            database.name = this.name;
            database.host = this.host;
            database.port = this.port;
            database.type = this.type;
            return database;
        }

        // Step 5 - Add a validation method
        public Boolean isValid() {
            if (this.name == null) {
                return false;
            }
            return true;
        }
    }
    
}
