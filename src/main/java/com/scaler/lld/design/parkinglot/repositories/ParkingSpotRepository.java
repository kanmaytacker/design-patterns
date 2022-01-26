package com.scaler.lld.design.parkinglot.repositories;

import java.util.ArrayList;
import java.util.List;

import com.scaler.lld.design.parkinglot.models.ParkingSpot;
import com.scaler.lld.design.parkinglot.models.SpotStatus;
import com.scaler.lld.design.parkinglot.models.VehicleType;

public class ParkingSpotRepository {
    
    List<ParkingSpot> parkingSpots = new ArrayList<>();

    public ParkingSpot save(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
        return parkingSpot;
    }

    public ParkingSpot findOneByVehicleTypeAndStatusAvailable(VehicleType type) {
        
        for (ParkingSpot parkingSpot: parkingSpots) {
            
            if (parkingSpot.getStatus() == SpotStatus.AVAILABLE && parkingSpot.getVehicleType() == type){
                return parkingSpot;
            }
        }

        return null;
    }

}
