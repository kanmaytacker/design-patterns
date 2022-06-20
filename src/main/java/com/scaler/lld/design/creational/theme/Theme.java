package com.scaler.lld.design.creational.theme;

public abstract class Theme {
    private String name;
    private String authorName;
    private String primaryColor;

    public abstract ThemeComponentFactory createThemeFactory();
    public abstract boolean changePrimaryColour(String colour);
}
