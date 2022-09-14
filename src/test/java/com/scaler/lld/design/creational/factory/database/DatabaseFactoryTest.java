package com.scaler.lld.design.creational.factory.database;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DatabaseFactoryTest {
    
    public NewDatabaseDriver driverFactory = null;

    @Before
    public void setUp() {
        driverFactory = new MySqlDriver();
    }

    @Test
    public void testMySqlDriver() {
        assertTrue(driverFactory.initialise() instanceof MySqlDriver);
    }
}
