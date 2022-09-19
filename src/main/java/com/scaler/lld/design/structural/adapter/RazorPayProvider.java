package com.scaler.lld.design.structural.adapter;

import com.scaler.lld.design.structural.adapter.external.RazorPayApi;
import com.scaler.lld.design.structural.adapter.external.RazorPayStatus;

// Step 2 - Concrete adapters
public class RazorPayProvider implements PaymentProviderInterface {
    
    private RazorPayApi razorPayApi = new RazorPayApi();

    @Override
    public String generateLink() {
        return razorPayApi.makeLink();
    }

    @Override
    public void pay(PaymentRequest paymentRequest) {
        razorPayApi.prePay();
        razorPayApi.pay(paymentRequest.getName(), paymentRequest.getAmount());        
    }

    @Override
    public PaymentStatus checkStatus() {
        RazorPayStatus status = razorPayApi.checkStatus();
        return toPaymentStatus(status);
    }

    private PaymentStatus toPaymentStatus(RazorPayStatus status) {
        
        if (status == RazorPayStatus.PASS) {
            return PaymentStatus.SUCCESS;
        }
        return PaymentStatus.FAILURE;
    }

    
}
