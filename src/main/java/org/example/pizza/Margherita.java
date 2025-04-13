package org.example.pizza;

import org.example.baseclass.Pizza;
import org.example.baseclass.Size;

import java.util.List;

/**
 *  Класс с пиццей "Маргарита"
 */
public class Margherita extends Pizza {
    public Margherita(Size size) {
        super(size);
        this.name = "Маргарита";
        this.basePrice = 400;
        this.ingredients = List.of("тесто", "томатный соус", "моцарелла", "помидоры", "базилик");
    }


}
