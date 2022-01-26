package com.scaler.lld.design.parkinglot.services;

import java.time.LocalDateTime;

import com.scaler.lld.design.parkinglot.models.ParkingSpot;
import com.scaler.lld.design.parkinglot.models.Ticket;
import com.scaler.lld.design.parkinglot.models.VehicleType;
import com.scaler.lld.design.parkinglot.repositories.TicketRepository;

public class TicketService {

    private TicketRepository ticketRepository = new TicketRepository();

    public Ticket createTicket(VehicleType vehicleType, ParkingSpot spot) {

        Ticket ticket = Ticket
                .builder()
                .entryTime(LocalDateTime.now())
                .floorNumber(spot.getFloorNumber())
                .slotNumber(spot.getSpotId())
                .build();

        return ticketRepository.save(ticket);
    }

}
