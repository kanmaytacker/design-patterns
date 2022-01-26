package com.scaler.lld.design.parkinglot.services;

import com.scaler.lld.design.parkinglot.models.ParkingSpot;
import com.scaler.lld.design.parkinglot.repositories.ParkingSpotRepository;

public class ParkingSpotService {

    private ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

    public void markSlotBooked(ParkingSpot spot) {
        parkingSpotRepository.save(spot);
    }

}
