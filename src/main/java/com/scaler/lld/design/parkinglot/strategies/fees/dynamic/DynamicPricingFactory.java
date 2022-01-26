package com.scaler.lld.design.parkinglot.strategies.fees.dynamic;

import com.scaler.lld.design.parkinglot.models.VehicleType;
import com.scaler.lld.design.parkinglot.strategies.fees.FeesFactory;
import com.scaler.lld.design.parkinglot.strategies.fees.FeesStrategy;

public class DynamicPricingFactory implements FeesFactory {
    
    public FeesStrategy getStrategy(VehicleType vehicleType) {
        switch(vehicleType) {
            case SMALL:
                return new SmallVehicleDynamicStrategy();
            case LARGE:
            case MEDIUM:
                throw new RuntimeException("Not implemented");
        }
        
        throw new RuntimeException("Invalid type!");
    }
}
