package org.example.baseclass;

import org.example.exceptions.IngredientMissingException;
import org.example.exceptions.KitchenOverloadedException;

public interface IKitchen {
    void prepareOrder(Order order) throws KitchenOverloadedException, IngredientMissingException;
    int getMaxOrders();
    int getCurrentOrders();
}
