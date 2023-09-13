package com.scaler.lld.design.behavioural.strategy.navigator;

// Step 2 - Create the concrete strategies
public class WalkingStrategy implements NavigationStrategy {
    @Override
    public void navigate(String from, String to) {
        System.out.println("Navigating using the walking mode.");
    }
}
