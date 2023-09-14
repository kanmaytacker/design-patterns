package com.scaler.lld.design.behavioural.strategy.navigator;

import java.util.List;

// Step 1 - Create the strategy interface
public interface NavigationStrategy {
    void navigate(String from, String to);

    default void start() {
        System.out.println("Starting");
    }

    default void stop() {
        System.out.println("Stopping");
    }
}
