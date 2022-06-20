package com.scaler.lld.design.creational.theme.primary;

import com.scaler.lld.design.creational.theme.Theme;
import com.scaler.lld.design.creational.theme.ThemeComponentFactory;

public class PrimaryTheme extends Theme {
    @Override
    public ThemeComponentFactory createThemeFactory() {
        return new PrimaryComponentFactory();
    }

    @Override
    public boolean changePrimaryColour(String colour) {
        return false;
    }
}
