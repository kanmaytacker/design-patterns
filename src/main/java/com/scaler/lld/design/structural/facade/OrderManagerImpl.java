package com.scaler.lld.design.structural.facade;

public class OrderManagerImpl implements OrderManager {

    private OrderProcessor orderProcessor;

    @Override
    public void createOrder() {
        // Store it in db

        // Async
        orderProcessor.process();
    }

}

// God class - not maintainable
// Testing
// Extensibility
//