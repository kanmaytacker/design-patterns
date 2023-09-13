package com.scaler.lld.design.creational.factorymethod.button;

public class SquareButtonFactory implements ButtonFactory {
    @Override
    public Button createButton(Double border, Double radius, Double length) {
        return new SquareButton(border, length);
    }
}
