package com.scaler.lld.design.structural.decorator.pizza;


public class PaneerDecorator extends BaseDecorator {
    public PaneerDecorator(Pizza nextLayer) {
        super(nextLayer);
    }
}
