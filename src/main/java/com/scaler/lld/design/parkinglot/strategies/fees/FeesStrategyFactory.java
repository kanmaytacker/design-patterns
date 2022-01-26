package com.scaler.lld.design.parkinglot.strategies.fees;

import com.scaler.lld.design.parkinglot.strategies.fees.dynamic.DynamicPricingFactory;

public class FeesStrategyFactory {
    
    public static FeesFactory getFactory(String pricingScheme){
        switch(pricingScheme) {
            case "TimeBased":
                return new TimeBasedFeesFactory();
            case "Dynamic":
                return new DynamicPricingFactory();
        }

        throw new RuntimeException();
    } 
}
