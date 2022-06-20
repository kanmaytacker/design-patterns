package com.scaler.lld.design.creational.tax;

import com.scaler.lld.design.creational.tax.algorithm.NewTaxAlgorithm;
import com.scaler.lld.design.creational.tax.algorithm.OldTaxAlgorithm;
import com.scaler.lld.design.creational.tax.algorithm.TaxAlgorithm;

public class TaxCalculatorFactory {

    public static TaxAlgorithm getTaxCalculator(TaxRegime regime) {
        switch (regime) {
            case OLD:
                return new OldTaxAlgorithm();
            case NEW:
                return new NewTaxAlgorithm();
        }

        throw new RuntimeException("Invalid regime" + regime);
    }
}
