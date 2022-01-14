package com.scaler.lld.design.behavioural.observer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BitcoinTrackerTest {
    private BitcoinTracker tracker;

    @Before
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
