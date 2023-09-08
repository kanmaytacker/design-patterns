package com.scaler.lld.design.creational.factory.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseFactoryTest {
    
    public NewDatabaseDriver driverFactory = null;

    @BeforeEach
    public void setUp() {
        driverFactory = new MySqlDriver();
    }

    @Test
    public void testMySqlDriver() {
        assertTrue(driverFactory.initialise() instanceof MySqlDriver);
    }
}
