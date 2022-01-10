package com.scaler.lld.design.creational.singleton;

public class ConnectionPool {
    // Step 3
    private static ConnectionPool INSTANCE = null; // Eager initialization - slow startup

    private ConnectionPool() {
        // Step 1 - private constructor
    }

    public static ConnectionPool getInstance() {
        // Step 2 - public static method
        if (INSTANCE == null) {
            // Step 4
            synchronized (ConnectionPool.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConnectionPool();
                }
            }
        }

        return INSTANCE;
    }

}

// Cons of this approach:
// 1. SRP violation
// 2. Thread safety is not guaranteed
// 3. Performance is not guaranteed in thread-safe mode - Double checked locking
// Enum implementation, inner static class 
