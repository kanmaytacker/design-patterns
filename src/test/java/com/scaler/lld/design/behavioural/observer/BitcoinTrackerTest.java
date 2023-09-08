package com.scaler.lld.design.behavioural.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitcoinTrackerTest {
    private BitcoinTracker tracker;

    @BeforeEach
    public void setUp() {
        tracker = new BitcoinTracker();
        EmailNotifier emailNotifier = new EmailNotifier();
        
        tracker.register(emailNotifier);
        tracker.register(new TweetService());
    }

    @Test
    public void testPrice() {
        tracker.setPrice(100.0);
        Bitcoin bitcoin = tracker.getBitcoin();
        assertEquals(100.0, bitcoin.getPrice(), 0.0);
    }

}
