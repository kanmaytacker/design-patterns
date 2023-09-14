package com.scaler.lld.design.structural.facade;

public class Main {

    private static OrderFlowProcessor orderFlowProcessor = new OrderFlowProcessor();
    public static void main(String[] args) {
        orderFlowProcessor.process();
    }
}
