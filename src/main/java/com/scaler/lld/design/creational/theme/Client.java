package com.scaler.lld.design.creational.theme;

import com.scaler.lld.design.creational.theme.primary.PrimaryTheme;

public class Client {
    public static void main(String[] args) {

        Theme theme = new PrimaryTheme();
        ThemeComponentFactory componentFactory = theme.createThemeFactory();

        Button button = componentFactory.createButton();
        Menu menu = componentFactory.createMenu();
        Dropdown dropdown = componentFactory.createDropdown();
    }
}
