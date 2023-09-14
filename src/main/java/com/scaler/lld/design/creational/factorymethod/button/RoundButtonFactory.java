package com.scaler.lld.design.creational.factorymethod.button;

public class RoundButtonFactory implements ButtonFactory {

    @Override
    public Button createButton(Double border, Double radius, Double length) {
        return new RoundButton(border, radius);
    }
}
