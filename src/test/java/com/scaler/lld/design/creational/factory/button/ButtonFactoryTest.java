package com.scaler.lld.design.creational.factory.button;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.scaler.lld.design.creational.factory.button.models.Button;
import com.scaler.lld.design.creational.factory.button.models.PrimaryButton;
import com.scaler.lld.design.creational.factory.button.models.RoundButton;

public class ButtonFactoryTest {
    
    @Test
    public void testButtonFactory() {
        ButtonFactory buttonFactory = new RoundButtonFactory();
        Button round = buttonFactory.createButton();

        assertNotNull("If factory method is called, it should return a non-null instance", round);
        assertTrue("If round button factory is called, it should return a round button", round instanceof RoundButton);
        
        ButtonFactory primaryFactory = new PrimaryButtonFactory();
        Button primary = primaryFactory.createButton();
        
        assertNotNull("If factory method is called, it should return a non-null instance", primary);
        assertTrue("If primary button factory is called, it should return a primary button", primary instanceof PrimaryButton);
        
    }
}
