package com.scaler.lld.design.creational.simplefactory.database;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
