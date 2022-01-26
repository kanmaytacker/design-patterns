package com.scaler.lld.design.parkinglot.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingLot {
    
    private String name;
    private String address;
    
    List<ParkingFloor> parkingFloors = new ArrayList<>();
    List<EntryGate> entryGates = new ArrayList<>();
    List<ExitGate> exitGates = new ArrayList<>();

    public static Builder toBuilder() {
        return new Builder();
    }

    public static class Builder {
        
        private ParkingLot parkingLot;

        private Builder() {
            this.parkingLot = new ParkingLot();
        }

        public Builder withFloors(int floors, int capacityPerFloor) {
            
            List<ParkingFloor> parkingFloors = Collections.nCopies(floors, new ParkingFloor());

            for (int index = 0; index < floors; index++) {
                
                ParkingFloor floor = parkingFloors.get(index);
                
                floor.setFloorNumber(index + 1);
                floor.setDisplayBoard(new DisplayBoard());
                
                List<ParkingSpot> spots = Collections.nCopies(capacityPerFloor, new ParkingSpot());
                floor.setParkingSpots(spots);
            }

            parkingLot.setParkingFloors(parkingFloors);

            return this;
        }

        public ParkingLot build() {
            return parkingLot;
        }
    }

}
