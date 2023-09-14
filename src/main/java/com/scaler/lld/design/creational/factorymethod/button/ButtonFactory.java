package com.scaler.lld.design.creational.factorymethod.button;

public interface ButtonFactory {
    // Step 3 - Factory method
    Button createButton(Double border, Double radius, Double length);
}
