package com.scaler.lld.design.behavioural.strategy.map;

import com.scaler.lld.design.behavioural.strategy.map.interfaces.NavigationStrategy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Navigator {

    NavigationStrategy strategy;

    public void navigate(String source, String destination) {
        strategy.navigate(source, destination);
    }
}
