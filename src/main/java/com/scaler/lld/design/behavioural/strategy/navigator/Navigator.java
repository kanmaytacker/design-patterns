package com.scaler.lld.design.behavioural.strategy.navigator;

import lombok.AllArgsConstructor;

import java.util.List;

// Step 3 - Modify the context class
@AllArgsConstructor
public class Navigator {

    // Add a local variable for the strategy
    private NavigationStrategy navigationStrategy;

    // Delegate the call to the strategy
    public void navigate(String from, String to) {
        navigationStrategy.navigate(from, to);
    }

    public void navigate(List<String> from, List<String> to) {
        for (int i = 0; i < from.size(); i++) {
            navigationStrategy.navigate(from.get(i), to.get(i));
        }
    }
}
