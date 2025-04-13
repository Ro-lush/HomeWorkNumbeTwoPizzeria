package org.example;

import org.example.baseclass.*;
import org.example.exceptions.IngredientMissingException;
import org.example.exceptions.KitchenOverloadedException;

import java.util.List;

import static org.example.baseclass.Size.*;

public class Main {
    public static void main(String[] args) throws KitchenOverloadedException, IngredientMissingException {

        PizzaMenu menu = new PizzaMenu();
        Kitchen kitchen = new Kitchen();


        // Создаем клиентов
        Customer customer1 = new Customer("Иван");
        Customer customer2 = new Customer("Мария");

        // Показываем меню
        menu.displayMenu();


        // Первый заказ
        Order order1 = new Order(customer1);
        order1.addPizza(menu.createPizza("Маргарита", LARGE, List.of("двойной сыр")));
        order1.addPizza(menu.createPizza("Пепперони", MEDIUM, List.of()));
        order1.addPizza(menu.createPizza("Пепперони", SMALL, List.of()));
        order1.confirm();
        kitchen.prepareOrder(order1);


        // Второй заказ
        Order order2 = new Order(customer2);
        order2.addPizza(menu.createPizza("Маргарита", MEDIUM, List.of("оливки")));
        order2.addPizza(menu.createPizza("Пепперони", LARGE, List.of("двойной сыр")));
        order2.confirm();
        kitchen.prepareOrder(order2);


        // Пытаемся сделать третий заказ, когда кухня занята
        Order order3 = new Order(new Customer("Алексей"));
        order3.addPizza(menu.createPizza("Маргарита", MEDIUM, List.of()));
        order3.confirm();
        kitchen.prepareOrder(order3);


        // Показываем остатки на кухне после заказов
        kitchen.showBalances();
    }

}