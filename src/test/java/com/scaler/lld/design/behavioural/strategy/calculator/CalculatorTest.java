package com.scaler.lld.design.behavioural.strategy.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calculator = null;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {

        int a = 10;
        int b = 2;

        calculator.setStrategy(new AdditionStrategy());

        int sum = calculator.performCalculation(a, b);
        assertEquals(a + b, sum);
    }

    @Test
    public void testSubtraction() {

        int a = 10;
        int b = 2;

        calculator.setStrategy(new SubtractionStrategy());

        int difference = calculator.performCalculation(a, b);
        assertEquals(a - b, difference);
    }

}
