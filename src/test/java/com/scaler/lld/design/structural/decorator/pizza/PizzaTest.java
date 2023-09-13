package com.scaler.lld.design.structural.decorator.pizza;

public class PizzaTest {

    void testPizza() {
        Pizza pizza = new BasePizza();
        Pizza saucePizza = new TomatoSauceDecorator(pizza);
        Pizza cheesePizza = new CheeseDecorator(saucePizza);
        Pizza paneerPizza = new PaneerDecorator(cheesePizza);
    }
}
