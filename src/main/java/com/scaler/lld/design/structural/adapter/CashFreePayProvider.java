package com.scaler.lld.design.structural.adapter;

import com.scaler.lld.design.structural.adapter.external.CashfreeApi;
import com.scaler.lld.design.structural.adapter.external.CashfreeStatus;

public class CashFreePayProvider implements PaymentProviderInterface {

    private CashfreeApi cashfreeApi;

    @Override
    public String generateLink() {
        return cashfreeApi.createURL();
    }

    @Override
    public void pay(PaymentRequest paymentRequest) {
        cashfreeApi.doPayment(paymentRequest.getAmount());
    }

    @Override
    public PaymentStatus checkStatus() {
        CashfreeStatus status = cashfreeApi.verifyStatus();
        return  toPaymentStatus(status);
    }

    private PaymentStatus toPaymentStatus(CashfreeStatus status) {
        if (status == CashfreeStatus.OK) {
            return PaymentStatus.SUCCESS;
        }
        return PaymentStatus.FAILURE;
    }

    
    
}
