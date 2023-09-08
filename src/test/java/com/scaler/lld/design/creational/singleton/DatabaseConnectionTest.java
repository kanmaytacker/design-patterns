package com.scaler.lld.design.creational.singleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseConnectionTest {
    
    @Test
    public void test() {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        ConnectionPool pool2 = ConnectionPool.getInstance();

        assertTrue(pool == pool2, "If a new instance is created, it should be the same as the older one");
    }
}
