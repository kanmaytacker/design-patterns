package com.scaler.lld.design.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSpot {
    private Integer spotId;
    private Integer floorNumber;
    private VehicleType vehicleType; 
    private SpotStatus status = SpotStatus.AVAILABLE;
}
