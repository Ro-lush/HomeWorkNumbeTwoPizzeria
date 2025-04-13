package org.example.baseclass;

import java.util.ArrayList;
import java.util.List;


public abstract class Pizza {
    protected String name;
    protected Size size;
    protected double basePrice;
    protected List<String> ingredients;
    protected List<String> extras = new ArrayList<>();

    //список размеров пиццы
    public enum Size {

        SMALL(0.5),
        MEDIUM(1.0),
        LARGE(1.5);

        private final double multiplier;

        Size(double multiplier) {
            this.multiplier = multiplier;
        }

        public double getMultiplier() {
            return multiplier;
        }
    }

    public Pizza(Size size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return basePrice * size.getMultiplier() + extras.size() * 50;
    }

    public void addExtra(String extra) {
        extras.add(extra);
    }

    public String getDescription() {
        return String.format("%s (%s) - %.2f руб. %s", name, size, getPrice(),
                extras.isEmpty() ? "" : "Добавки: " + String.join(", ", extras));
    }

    public List<String> getIngredients() {
        List<String> allIngredients = new ArrayList<>(ingredients);
        allIngredients.addAll(extras);
        return allIngredients;
    }
}
