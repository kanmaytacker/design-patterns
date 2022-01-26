package com.scaler.lld.design.parkinglot.services;

import com.scaler.lld.design.parkinglot.models.ParkingSpot;
import com.scaler.lld.design.parkinglot.models.VehicleType;
import com.scaler.lld.design.parkinglot.repositories.ParkingSpotRepository;

public class SlotAllocationService {
    
    private ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

    public ParkingSpot allocateSlot(VehicleType vehicleType) {
        return parkingSpotRepository.findOneByVehicleTypeAndStatusAvailable(vehicleType);
    }

}
