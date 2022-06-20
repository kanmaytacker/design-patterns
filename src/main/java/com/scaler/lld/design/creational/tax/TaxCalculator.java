package com.scaler.lld.design.creational.tax;

public class TaxCalculator {

    public static Double calculateTax(TaxRegime regime, SalaryDetails salaryDetails) {
        switch (regime) {
            case OLD:
                return 0.4 * salaryDetails.getBasePay()
                        + 0.3 * salaryDetails.getHra();
            case NEW:
                return 0.4 * salaryDetails.getBasePay()
                        + 0.3 * salaryDetails.getHra()
                        + 0.2 * salaryDetails.getLta();
        }

        throw new RuntimeException("Invalid regime" + regime);
    }
}
