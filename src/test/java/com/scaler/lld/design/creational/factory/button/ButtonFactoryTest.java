package com.scaler.lld.design.creational.factory.button;

import org.junit.jupiter.api.Test;


import com.scaler.lld.design.creational.factory.button.models.Button;
import com.scaler.lld.design.creational.factory.button.models.PrimaryButton;
import com.scaler.lld.design.creational.factory.button.models.RoundButton;

import static org.junit.jupiter.api.Assertions.*;

public class ButtonFactoryTest {
    
    @Test
    public void testButtonFactory() {
        ButtonFactory buttonFactory = new RoundButtonFactory();
        Button round = buttonFactory.createButton();

        assertNotNull(round, "If factory method is called, it should return a non-null instance");
        assertTrue(round instanceof RoundButton, "If round button factory is called, it should return a round button");
        
        ButtonFactory primaryFactory = new PrimaryButtonFactory();
        Button primary = primaryFactory.createButton();
        
        assertNotNull(primary, "If factory method is called, it should return a non-null instance");
        assertTrue(primary instanceof PrimaryButton, "If primary button factory is called, it should return a primary button");
        
    }
}
