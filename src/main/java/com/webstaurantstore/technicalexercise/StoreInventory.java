package com.webstaurantstore.technicalexercise;

import java.util.ArrayList;
import java.util.List;

public class StoreInventory {
    
    // List will store all products
    private List<Product> products;

    // Constructor
    public StoreInventory() {
        products = new ArrayList<>();
    }

    // Getter
    public List<Product> getProducts() {
        return products;
    }

    // Add a product
    public void addProduct(Product product) {
        products.add(product);
    }

    // Remove a product
    public void removeProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
            }
        }
    }

    // Update quantity of a product
    public void updateQuantity(Product product, int newQuantity) {
        product.setQuantity(newQuantity);
    }

    // List all products
    public void viewInventory() {

        System.out.println("Inventory Details:");
        System.out.println("====================");
    
        for (Product product : products) {
            System.out.println("Name:         " + product.getName());
            System.out.println("ID:           " + product.getId());
            System.out.println("Price:        $" + String.format("%.2f", product.getPrice()));
            System.out.println("Quantity:     " + product.getQuantity());
            System.out.println("--------------------");
        }

    }

    // Total inventory value
    public float calculateInventoryValue() {
        float value = 0;
        for (Product product : products) {
            value += (product.getQuantity() * product.getPrice());
        }
        System.out.println("The total inventory value is: " + value);
        return value;
    }

}

