package com.scaler.lld.design.creational.factorymethod.button;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ButtonFactoryTest {

    @Test
    public void testRoundButton() {
        // Condition dependency injection -> @Qualifier
        ButtonFactory buttonFactory = new RoundButtonFactory();

        Button button = buttonFactory.createButton(10.0, 0.4, null);

        assertTrue(button instanceof RoundButton,
                "If the screen size is of a phone, the btn should be round"
        );

    }
}
