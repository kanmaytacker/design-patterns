package com.scaler.lld.design.creational.simplefactory;

public class DatabaseDriverFactory {
    
    public static DatabaseDriver getDatabaseDriver(String driverType) {

        if (driverType.equalsIgnoreCase("mysql")) {
            return new MySqlDatabaseDriver();
        } else if (driverType.equalsIgnoreCase("oracle")) {
            return new OracleDatabaseDriver();
        }

        return null;
    }
}
