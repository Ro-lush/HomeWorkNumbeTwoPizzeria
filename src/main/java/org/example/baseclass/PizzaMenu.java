package org.example.baseclass;

import org.example.pizza.Margherita;
import org.example.pizza.Pepperoni;

import java.util.ArrayList;
import java.util.List;

public class PizzaMenu {
    private final List<Pizza> availablePizzas;

    public PizzaMenu() {
        availablePizzas = new ArrayList<>();
        availablePizzas.add(new Margherita(Size.MEDIUM));
        availablePizzas.add(new Pepperoni(Size.MEDIUM));

    }

    /**
     * Метод для вывода меню
     */
    public void displayMenu() {
        System.out.println("\nМеню пиццерии:");
        for (Pizza pizza : availablePizzas) {
            System.out.println(pizza.getDescription());
        }
        System.out.println("Добавки: двойной сыр (+50р.), грибы (+50р.), оливки (+50р.)");
    }

    /**
     * Метод для создания пиццы
     * @param name - наименование
     * @param size - размер
     * @param extras - добавки
     * @return
     */
    public Pizza createPizza(String name, Size size, List<String> extras) {
        Pizza pizza = null;

        switch (name.toLowerCase()) {
            case "маргарита":
                pizza = new Margherita(size);
                break;
            case "пепперони":
                pizza = new Pepperoni(size);
                break;
            default:
                System.out.println("Такой пиццы нет в меню!");
                return null;
        }

        for (String extra : extras) {
            pizza.addExtra(extra);
        }

        return pizza;
    }
}
