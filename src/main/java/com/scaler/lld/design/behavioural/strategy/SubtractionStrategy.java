package com.scaler.lld.design.behavioural.strategy;

public class SubtractionStrategy implements OperationStrategy {

    @Override
    public int operate(int a, int b) {
        return a - b;
    }

}
