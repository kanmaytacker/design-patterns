package com.scaler.lld.design.structural.adapter.external;

public class CashfreeApi {
    
    public String createURL() {
        return "Cashfree";
    }
    
    public void doPayment(int amount) {
        System.out.println("Cashfree Payment" + amount);
    }
    
    public CashfreeStatus verifyStatus() {
        return CashfreeStatus.OK;
    }
    
}
