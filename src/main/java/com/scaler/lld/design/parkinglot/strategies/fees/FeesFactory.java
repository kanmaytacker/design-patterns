package com.scaler.lld.design.parkinglot.strategies.fees;

import com.scaler.lld.design.parkinglot.models.VehicleType;

public interface FeesFactory {
    
    public FeesStrategy getStrategy(VehicleType vehicleType);
}
