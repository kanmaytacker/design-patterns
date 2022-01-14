package com.scaler.lld.design.behavioural.strategy;

// Step 2 - Adding concrete strategies
public class AdditionStrategy implements OperationStrategy {

    @Override
    public int operate(int a, int b) {
        return a + b;
    }

}
