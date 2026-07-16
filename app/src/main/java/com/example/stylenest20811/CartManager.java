package com.example.stylenest20811;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static CartManager instance;
    private List<Product> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static synchronized CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addProduct(Product product) {
        cartItems.add(product);
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product item : cartItems) {
            // Very simple price parsing for demo purposes
            String priceStr = item.getPrice().replace("$", "");
            try {
                total += Double.parseDouble(priceStr);
            } catch (NumberFormatException e) {
                // Ignore invalid prices
            }
        }
        return total;
    }

    public void clearCart() {
        cartItems.clear();
    }
}
