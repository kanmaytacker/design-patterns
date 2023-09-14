package com.scaler.lld.design.creational.builder.database;

import lombok.Getter;

@Getter
public class Database {
    private String name;
    private String host;
    private int port;
    private DatabaseType type;

    private Database() {
    }

    // Step 1 - Hide the constructor
    private Database(String name, String host, int port, DatabaseType type) {
        this.name = name;
        this.host = host;
        this.port = port;
        this.type = type;
    }

    // Add a static method to get the builder object
    public static DatabaseBuilder builder() {
        return new DatabaseBuilder();
    }

    // Step 2 - Create a static inner class with same fields as the outer class
    public static class DatabaseBuilder {
        private Database database;

        DatabaseBuilder() {
            this.database = new Database();
        }

        // Step 3 - Create fluent interfaces for setter
        public DatabaseBuilder withName(String name) {
            this.database.name = name;
            return this;
        }

        public DatabaseBuilder withUrl(String host, int port) {
            this.database.host = host;
            this.database.port = port;
            return this;
        }

        public DatabaseBuilder mysql() {
            this.database.type = DatabaseType.MYSQL;
            return this;
        }

        // Step 4 - Create a build method to return the outer class object
        public Database build() {

            if (!isValid()) {
                throw new IllegalArgumentException("Invalid database configuration");
            }

            return new Database(this.database.name, this.database.host, this.database.port,
                    this.database.type);
        }

        // Step 5 - Add a validation method
        public Boolean isValid() {
            if (this.database.name == null) {
                return false;
            }
            return true;
        }
    }

}
