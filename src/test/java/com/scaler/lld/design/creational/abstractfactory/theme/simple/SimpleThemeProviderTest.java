package com.scaler.lld.design.creational.abstractfactory.theme.simple;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.scaler.lld.design.creational.abstractfactory.theme.interfaces.ThemeFactory;
import com.scaler.lld.design.creational.abstractfactory.theme.models.ThemeType;
import com.scaler.lld.design.creational.factory.button.models.Button;
import com.scaler.lld.design.creational.factory.button.models.CheckBox;
import com.scaler.lld.design.creational.factory.button.models.DarkCheckBox;
import com.scaler.lld.design.creational.factory.button.models.LightCheckBox;
import com.scaler.lld.design.creational.factory.button.models.PrimaryButton;
import com.scaler.lld.design.creational.factory.button.models.RoundButton;

public class SimpleThemeProviderTest {
    
    @Test
    public void testDarkTheme() {
        ThemeFactory factory = ThemeProvider.getThemeFactory(ThemeType.DARK);
        Button button = factory.createButton();
        CheckBox checkBox = factory.createCheckBox();

        assertNotNull("If factory is called, button should not be null", button);
        assertNotNull("If factory is called, checkbox should not be null", checkBox);

        assertTrue("If Dark theme factory is used, button should be of type RoundButton", button instanceof RoundButton);
        assertTrue("If Dark theme factory is used, checkbox should be of type DarkCheckBox", checkBox instanceof DarkCheckBox);
    }

    @Test
    public void testLightTheme() {
        ThemeFactory factory = ThemeProvider.getThemeFactory(ThemeType.LIGHT);
        Button button = factory.createButton();
        CheckBox checkBox = factory.createCheckBox();

        assertNotNull("If factory is called, button should not be null", button);
        assertNotNull("If factory is called, checkbox should not be null", checkBox);

        assertTrue("If Light theme factory is used, button should be of type PrimaryButton", button instanceof PrimaryButton);
        assertTrue("If Light theme factory is used, checkbox should be of type LightCheckBox", checkBox instanceof LightCheckBox);
    }

}
