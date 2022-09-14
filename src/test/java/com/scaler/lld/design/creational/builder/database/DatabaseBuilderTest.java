package com.scaler.lld.design.creational.builder.database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DatabaseBuilderTest {

    @Test
    public void testDatabaseBuilder() {
        Database database = Database.builder()
                .mysql()
                .withName("test")
                .withUrl("localhost", 8080)
                .build();

        assertNotNull("If build method is called, database object should not be null", database);
        assertEquals("If name is set, on fetching it should be the same", "test", database.getName());
        assertEquals("If mysql is set, on fetching it should be the same", DatabaseType.MYSQL, database.getType());
    }
}
