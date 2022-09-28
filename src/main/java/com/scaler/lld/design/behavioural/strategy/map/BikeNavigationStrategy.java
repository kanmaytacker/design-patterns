package com.scaler.lld.design.behavioural.strategy.map;

import com.scaler.lld.design.behavioural.strategy.map.interfaces.NavigationStrategy;

public class BikeNavigationStrategy implements NavigationStrategy {

    @Override
    public void navigate(String source, String destination) {
        System.out.println("Navigating from " + source + " to " + destination + " by bike");
    }

}