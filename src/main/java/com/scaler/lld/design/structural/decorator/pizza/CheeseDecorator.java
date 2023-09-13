package com.scaler.lld.design.structural.decorator.pizza;


public class CheeseDecorator extends BaseDecorator  {

    public CheeseDecorator(Pizza nextLayer) {
        super(nextLayer);
    }
}
