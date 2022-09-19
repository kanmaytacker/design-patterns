package com.scaler.lld.design.structural.adapter.external;


public class RazorPayApi {
    
    public String makeLink() {
        return "RazorPay";
    }

    public void prePay() {
        System.out.println("RazorPay PrePayment");
    }

    public void pay(String name, int amount) {
        System.out.println("RazorPay Payment" + name);
    }

    public RazorPayStatus checkStatus() {
        return RazorPayStatus.PASS;
    }

}
