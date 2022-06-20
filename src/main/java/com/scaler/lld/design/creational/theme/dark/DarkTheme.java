package com.scaler.lld.design.creational.theme.dark;

import com.scaler.lld.design.creational.theme.Theme;
import com.scaler.lld.design.creational.theme.ThemeComponentFactory;

public class DarkTheme extends Theme {
    @Override
    public ThemeComponentFactory createThemeFactory() {
        return new DarkComponentFactory();
    }

    @Override
    public boolean changePrimaryColour(String colour) {
        return false;
    }
}
