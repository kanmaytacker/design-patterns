package com.scaler.lld.design.creational.simplefactory.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class DatabaseDriverTest {

    @Test
    public void testMySqlDriver() {
        DatabaseDriver driver = DatabaseDriverFactory.getDatabaseDriver("mysql");
        assertTrue(driver instanceof MySqlDatabaseDriver);
    }

    @Test
    public void testOracleDriver() {
        DatabaseDriver driver = DatabaseDriverFactory.getDatabaseDriver("oracle");
        assertTrue(driver instanceof OracleDatabaseDriver);
    }
}
