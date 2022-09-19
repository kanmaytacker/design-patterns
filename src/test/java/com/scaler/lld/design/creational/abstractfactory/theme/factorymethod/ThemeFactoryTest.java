package com.scaler.lld.design.creational.abstractfactory.theme.factorymethod;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.scaler.lld.design.creational.abstractfactory.theme.interfaces.ThemeFactory;
import com.scaler.lld.design.creational.factory.button.models.Button;
import com.scaler.lld.design.creational.factory.button.models.CheckBox;
import com.scaler.lld.design.creational.factory.button.models.DarkCheckBox;
import com.scaler.lld.design.creational.factory.button.models.RoundButton;

public class ThemeFactoryTest {
    private ThemeFactory themeFactory;

    @Before
    public void setUp() {
        themeFactory = new DarkThemeFactory();
    }

    @Test
    public void testDarkTheme() {
        Button button = themeFactory.createButton();
        CheckBox checkBox = themeFactory.createCheckBox();

        assertNotNull("If factory is called, button should not be null", button);
        assertNotNull("If factory is called, checkbox should not be null", checkBox);

        assertTrue("If Dark theme factory is used, button should be of type RoundButton", button instanceof RoundButton);
        assertTrue("If Dark theme factory is used, checkbox should be of type DarkCheckBox", checkBox instanceof DarkCheckBox);
    }
}
