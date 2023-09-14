package com.scaler.lld.design.behavioural.strategy.navigator;

public class CarDrivingStrategy implements NavigationStrategy {
    @Override
    public void navigate(String from, String to) {
        start();
        System.out.println("Navigating using the car mode.");
        stop();
    }
}
