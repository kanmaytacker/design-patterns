package com.scaler.lld.design.parkinglot.services;

import com.scaler.lld.design.parkinglot.models.Ticket;
import com.scaler.lld.design.parkinglot.strategies.fees.FeesStrategy;
import com.scaler.lld.design.parkinglot.strategies.fees.FeesStrategyFactory;

public class FeesCalculatorService {

    public int calculateFees(Ticket ticket) {
        FeesStrategy strategy = FeesStrategyFactory
                .getFactory("TimeBased")
                .getStrategy(ticket.getVehicleType());
        return strategy.calculateFees(ticket);
    }

}

// Strategy design pattern
// On the basis of vehicle type, get the specific strategy - Factory
// On the basis of a parameter, get the specific interface.

// Parameter - PricingStrategy - Time based, Dynamic, ML
// Get the relevant set of strategies

// Get the right pricing strategy - pricing scheme
// Get the right fees calculation strategy - vehicle type

// Abstract Factory Pattern