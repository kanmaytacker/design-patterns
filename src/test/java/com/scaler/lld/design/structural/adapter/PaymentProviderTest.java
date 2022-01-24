package com.scaler.lld.design.structural.adapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PaymentProviderTest {
    
    PaymentProviderInterface paymentProvider = null;

    @Before
    public void setUp() {
        paymentProvider = new RazorPayProvider();
    }

    @Test
    public void testRazorPay() {
        assertTrue("If razor pay is used, then instance should be of RazorPay", paymentProvider instanceof RazorPayProvider);
        String link = paymentProvider.generateLink();
        assertEquals("RazorPay", link);
    }

    @Test
    public void testPaymentStatus() {
        PaymentStatus status = paymentProvider.checkStatus();
        assertEquals(PaymentStatus.SUCCESS, status);
    }

}
