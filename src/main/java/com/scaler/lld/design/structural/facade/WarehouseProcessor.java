package com.scaler.lld.design.structural.facade;

// Additional facade
public class WarehouseProcessor {
    private InventoryService inventoryService;
    private AnalyticsService analyticsService;

    public void process() {
        inventoryService.checkInventory();
        analyticsService.track();
    }
}
