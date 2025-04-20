package org.example.baseclass;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    protected String name;
    protected Size size;
    protected double basePrice;
    protected List<String> ingredients;
    protected List<String> extras = new ArrayList<>();

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
