package org.example.baseclass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для работы с заказами
 */
public class Order {

    private static int nextId = 1;
    private final int id;
    private final Customer customer;
    private final List<Pizza> pizzas;
    private boolean confirmed;

    public Order(Customer customer) {
        this.id = nextId++;
        this.customer = customer;
        this.pizzas = new ArrayList<>();
        this.confirmed = false;
    }

    public List<Pizza> getPizzas() {
        return new ArrayList<>(pizzas);
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    /**
     * Метод для получения цены
     *
     * @return
     */
    public double calculateTotal() {
        return pizzas.stream().mapToDouble(Pizza::getPrice).sum();
    }

    /**
     * Метод для подтверждения заказа
     */
    public void confirm() {
        this.confirmed = true;
        System.out.printf("\nЗаказ #%d подтвержден. Клиент %s заказал %d пицц: %s, общая цена - %.2f руб.%n",
                id, customer.getName(), pizzas.size(),
                String.join(", ", pizzas.stream().map(Pizza::getName).collect(Collectors.toList())),
                calculateTotal());
    }
}
