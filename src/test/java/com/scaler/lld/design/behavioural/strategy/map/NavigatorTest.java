package com.scaler.lld.design.behavioural.strategy.map;

import org.junit.jupiter.api.Test;

public class NavigatorTest {

    @Test
    public void testCarNavigation() {
        Navigator navigator = new Navigator(new RoadNavigationStrategy());
        navigator.navigate("Bangalore", "Mysore");
    }

    @Test
    public void testBikeNavigation() {
        Navigator navigator = new Navigator(new BikeNavigationStrategy());
        navigator.navigate("Bangalore", "Mysore");
    }

}
