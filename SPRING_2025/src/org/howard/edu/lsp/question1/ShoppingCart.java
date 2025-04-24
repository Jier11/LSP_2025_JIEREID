package org.howard.edu.lspfinal.question1;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a shopping cart that adds items, removes items, applies discount, and total cost.
 */
public class ShoppingCart {
    private Map<String, Double> items = new HashMap<>();
    private double discountPercentage = 0.0;

    /**
     * Adds item to shopping cart.
     *
     * @param itemName  name of item 
     * @param price     price of item 
     * @throws IllegalArgumentException itemName is empty or price is negative
     */
    public void addItem(String itemName, double price) {
        if (itemName == null || itemName.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
        if (price <= 0.0) {
            throw new IllegalArgumentException("Price must be positive.");
        }
        items.put(itemName, price);
    }

    /**
     * Removes item from shopping cart.
     *
     * @param itemName name of item 
     * @throws IllegalArgumentException item does not exist in cart
     */
    public void removeItem(String itemName) {
        if (!items.containsKey(itemName)) {
            throw new IllegalArgumentException("Item not found: " + itemName);
        }
        items.remove(itemName);
    }

    /**
     * Returns number of items currently in cart.
     *
     * @return item count
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Returns the total cost of the cart,
     * applies discounts in effect.
     *
     * @return total cost after discount
     */
    public double getTotalCost() {
        double total = 0.0;
        for (double price : items.values()) {
            total += price;
        }
        double discountAmount = total * (discountPercentage / 100.0);
        return total - discountAmount;
    }

    /**
     * Applies discount code to shopping cart.
     * - "SAVE10": 10% discount
     * - "SAVE20": 20% discount
     *
     * @param  discount code
     * @throws IllegalArgumentException code is invalid
     */
    public void applyDiscountCode(String code) {
        switch (code) {
            case "SAVE10":
                discountPercentage = 10.0;
                break;
            case "SAVE20":
                discountPercentage = 20.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid discount code.");
        }
    }

    /**
     * Returns current discount percentage applied to cart.
     * 
     *
     * @return discount percentage 
     */
    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
