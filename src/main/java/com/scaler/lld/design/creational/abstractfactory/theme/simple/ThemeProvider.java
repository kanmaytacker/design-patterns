package com.scaler.lld.design.creational.abstractfactory.theme.simple;

import com.scaler.lld.design.creational.abstractfactory.theme.factorymethod.DarkThemeFactory;
import com.scaler.lld.design.creational.abstractfactory.theme.factorymethod.LightThemeFactory;
import com.scaler.lld.design.creational.abstractfactory.theme.interfaces.ThemeFactory;
import com.scaler.lld.design.creational.abstractfactory.theme.models.ThemeType;

public class ThemeProvider {
    
    public static ThemeFactory getThemeFactory(ThemeType themeType) {
        switch (themeType) {
            case DARK:
                return new DarkThemeFactory();
            case LIGHT:
                return new LightThemeFactory();
        }

        throw new RuntimeException("Invalid theme type" + themeType);
    }
}
