package com.scaler.lld.design.structural.facade;

public class OrderFlowProcessor {
    private PaymentService paymentService = new PaymentService();
    private InventoryService inventoryService = new InventoryService();
    private RecommendationService recommendationService = new RecommendationService();
    private AnalyticsService analyticsService = new AnalyticsService();

    public void process() {
        paymentService.pay();
        // update
        inventoryService.checkInventory();
        // analytics
        recommendationService.recommend();
        analyticsService.track();
    }
}
