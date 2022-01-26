package com.scaler.lld.design.parkinglot.controllers;

import com.scaler.lld.design.parkinglot.dtos.GetTicketDTO;
import com.scaler.lld.design.parkinglot.models.VehicleType;
import com.scaler.lld.design.parkinglot.services.EntryGateService;

public class EntryGateController {
    
    EntryGateService entryGateService = new EntryGateService();

    public GetTicketDTO createTicket(VehicleType vehicleType) {
        return entryGateService.createTicket(vehicleType);
    }
}

// 1. See availability - getDisplayBoard()
// 2. Create ticket - createTicket()
