package org.example.baseclass;

import org.example.exceptions.IngredientMissingException;
import org.example.exceptions.KitchenOverloadedException;

import java.util.HashMap;
import java.util.Map;

public class Kitchen implements IKitchen {
    private static final int MAX_ORDERS = 1;
    private int currentOrders = 0;
    private final Map<String, Integer> ingredientsStock = new HashMap<>();


    // Инициализация запасов ингредиентов
    public Kitchen() {
        ingredientsStock.put("тесто", 20);
        ingredientsStock.put("томатный соус", 15);
        ingredientsStock.put("моцарелла", 15);
        ingredientsStock.put("помидоры", 10);
        ingredientsStock.put("базилик", 5);
        ingredientsStock.put("пепперони", 8);
        ingredientsStock.put("ветчина", 8);
        ingredientsStock.put("ананас", 6);
        ingredientsStock.put("двойной сыр", 2);
        //ingredientsStock.put("оливки", 1);

    }

    @Override
    public void prepareOrder(Order order) throws KitchenOverloadedException, IngredientMissingException {

        if (currentOrders >= MAX_ORDERS) {
            throw new KitchenOverloadedException("Кухня перегружена! Максимальное количество заказов: " + MAX_ORDERS);
        }

        // Проверка наличия ингредиентов
        for (Pizza pizza : order.getPizzas()) {
            for (String ingredient : pizza.getIngredients()) {
                if (!ingredientsStock.containsKey(ingredient) || ingredientsStock.get(ingredient) <= 0) {
                    throw new IngredientMissingException("Не хватает ингредиента: " + ingredient);
                }
            }
        }

        // Использование ингредиентов
        for (Pizza pizza : order.getPizzas()) {
            for (String ingredient : pizza.getIngredients()) {
                ingredientsStock.put(ingredient, ingredientsStock.get(ingredient) - 1);
            }
        }

        currentOrders++;
        System.out.printf("Кухня начала готовить заказ #%d для %s (%d пицц)%n",
                order.getId(), order.getCustomer().getName(), order.getPizzas().size());

        // Имитация приготовления
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        currentOrders--;
        System.out.printf("Заказ #%d для %s готов!%n", order.getId(), order.getCustomer().getName());
    }

    @Override
    public int getMaxOrders() {
        return currentOrders;
    }

    @Override
    public int getCurrentOrders() {
        return currentOrders;
    }

    /**
     * Метод для пополнения ингредиентов
     *
     * @param ingredient - название ингредиента
     * @param quantity   - количество
     */
    public void restockIngredient(String ingredient, int quantity) {
        ingredientsStock.put(ingredient, ingredientsStock.getOrDefault(ingredient, 0) + quantity);
    }

    /**
     * Метод для для показа остатков
     */
    public void showBalances() {
        System.out.println("\nОстатки на кухне:");
        for (Map.Entry<String, Integer> entry : ingredientsStock.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

