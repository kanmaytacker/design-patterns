package com.scaler.lld.design.parkinglot.strategies.fees;

import com.scaler.lld.design.parkinglot.models.Ticket;

public interface FeesStrategy {
    int calculateFees(Ticket ticket);
}
