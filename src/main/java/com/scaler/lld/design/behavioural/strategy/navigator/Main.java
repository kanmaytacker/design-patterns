package com.scaler.lld.design.behavioural.strategy.navigator;

public class Main {
    public static void main(String[] args) {
        Navigator navigator = new Navigator(new CarDrivingStrategy()); // Dependency injection
        navigator.navigate("Bangalore", "Mysore");
    }
}
