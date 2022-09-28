package com.scaler.lld.design.parkinglot.strategies.fees;

import com.scaler.lld.design.parkinglot.models.VehicleType;
import com.scaler.lld.design.parkinglot.strategies.fees.timebased.LargeVehicleTimeStrategy;
import com.scaler.lld.design.parkinglot.strategies.fees.timebased.MediumVehicleTimeStrategy;
import com.scaler.lld.design.parkinglot.strategies.fees.timebased.SmallVehicleTimeStrategy;

public class TimeBasedFeesFactory implements FeesFactory {

    public FeesStrategy getStrategy(VehicleType vehicleType) {
        switch (vehicleType) {
            case LARGE:
                return new LargeVehicleTimeStrategy();
            case MEDIUM:
                return new MediumVehicleTimeStrategy();
            case SMALL:
                return new SmallVehicleTimeStrategy();
        }

        throw new RuntimeException("Invalid type");
    }
}
