package com.scaler.lld.design.creational.abstractfactory.button;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AbstractButtonFactoryTest {

    @Test
    public void testLightTheme() {
        ThemeFactory lightThemeFactory = new LightThemeFactory();

        Button button = lightThemeFactory.createButton(10.0, 0.4, null);
        assertTrue(button instanceof LightButton,
                "If the factory is light, it should be a light button"
        );

        Radio radio = lightThemeFactory.createRadio();
        assertTrue(radio instanceof LightRadio,
                "If the factory is light, it should be a light radio"
        );

    }
}
