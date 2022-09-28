package com.scaler.lld.design.behavioural.strategy.calculator;

// Step 3 - Add a field for strategy 
public class Calculator {

    private OperationStrategy strategy = null;

    public void setStrategy(OperationStrategy operationStrategy) {
        this.strategy = operationStrategy;
    }

    public int performCalculation(int a, int b) {
        return strategy.operate(a, b);
    }

}
