package com.scaler.lld.design.creational.simplefactory.button;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ButtonTest {

    @Test
    public void testRoundButton() {
       /* Button button = ButtonFactory.createButton(
                ScreenSize.PHONE, 10.0, 1.0, null
        );*/
        Button button = ButtonFactory.getBuilder().setScreenSize(ScreenSize.PHONE).setRadius(10.0).setBorder(1.0).build();
        assertTrue(button instanceof RoundButton,
                "If the screen size is of a phone, the btn should be round"
        );
    }

    @Test
    public void testSquareButton() {
//        Button button = ButtonFactory.createButton(
//                ScreenSize.DESKTOP, 10.0, null, 10.0
//        );
        Button button = ButtonFactory.getBuilder().setScreenSize(ScreenSize.DESKTOP).setLength(10.0).setBorder(10.0).build();
        assertTrue(button instanceof SquareButton,
                "If the screen size is of a desktop, the btn should be square"
        );
    }
}

// Why the factory pattern?
// 1. SRP and OCP =>> Done
// 2. Complex construction logic ==> Done
// 3. Reduce usage of subclasses ==> Done

// What are the downsides of the simple factory?
// 1. Parameter explosion -> Assignment => Builder
// 2. SRP + OCP violation in library code
