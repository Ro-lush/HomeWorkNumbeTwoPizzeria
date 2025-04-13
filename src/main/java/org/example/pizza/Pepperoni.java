package org.example.pizza;

import org.example.baseclass.Pizza;
import org.example.baseclass.Size;

import java.util.List;

/**
 * Класс с пиццей "Пепперони"
 */
public class Pepperoni extends Pizza {

    public Pepperoni(Size size) {
        super(size);
        this.name = "Пепперони";
        this.basePrice = 500;
        this.ingredients = List.of("тесто", "томатный соус", "моцарелла", "пепперони");
    }

}
