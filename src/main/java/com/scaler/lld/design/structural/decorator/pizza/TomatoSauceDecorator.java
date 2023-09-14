package com.scaler.lld.design.structural.decorator.pizza;


public class TomatoSauceDecorator extends BaseDecorator {
    public TomatoSauceDecorator(Pizza nextLayer) {
        super(nextLayer);
    }
}
