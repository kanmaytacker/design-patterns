package com.scaler.lld.design.parkinglot.services;

import com.scaler.lld.design.parkinglot.dtos.GetTicketDTO;
import com.scaler.lld.design.parkinglot.models.ParkingSpot;
import com.scaler.lld.design.parkinglot.models.SpotStatus;
import com.scaler.lld.design.parkinglot.models.Ticket;
import com.scaler.lld.design.parkinglot.models.VehicleType;

public class EntryGateService {

    ParkingSpotService parkingSpotService = new ParkingSpotService();
    SlotAllocationService allocationService = new SlotAllocationService();
    TicketService ticketService = new TicketService();

    public GetTicketDTO createTicket(VehicleType vehicleType) {

        // Early returns
        ParkingSpot parkingSpot = allocationService.allocateSlot(vehicleType);
        if (parkingSpot == null) {
            throw new RuntimeException("Slot not available!");
        }

        // Update parking spot
        parkingSpot.setStatus(SpotStatus.FILLED);
        parkingSpotService.markSlotBooked(parkingSpot);

        // Create and persist ticket
        Ticket ticket = ticketService.createTicket(vehicleType, parkingSpot);

        return GetTicketDTO
                .builder()
                .entryTime(ticket.getEntryTime())
                .vehicleType(ticket.getVehicleType())
                .build();
    }

}

// 1. Availability - Get a slot if returns null, then not available.
// 1b. Update the status of the slot
// 2. Create a ticket
// 3. Persist/ save the ticket

// DB - models
// Outer world - FE, Client - DTO - Request, Response