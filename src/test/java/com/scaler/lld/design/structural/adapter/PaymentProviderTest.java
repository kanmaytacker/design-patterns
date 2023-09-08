package com.scaler.lld.design.structural.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PaymentProviderTest {
    
    PaymentProviderInterface paymentProvider = null;

    @BeforeEach
    public void setUp() {
        paymentProvider = new RazorPayProvider();
    }

    @Test
    public void testRazorPay() {
        assertTrue(paymentProvider instanceof RazorPayProvider, "If razor pay is used, then instance should be of RazorPay");
        String link = paymentProvider.generateLink();
        assertEquals("RazorPay", link);
    }

    @Test
    public void testPaymentStatus() {
        PaymentStatus status = paymentProvider.checkStatus();
        assertEquals(PaymentStatus.SUCCESS, status);
    }

}
