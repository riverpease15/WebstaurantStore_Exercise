package com.webstaurantstore.technicalexercise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StoreTest {
    
    private StoreInventory inventory;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        // Initialize inventory
        inventory = new StoreInventory();

        // Redirect System.out to get output
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        // Restore System.out to its original state
        System.setOut(originalOut);
        
        // Clear the output content for the next test
        outContent.reset();
    }

    @Test
    void testAddProduct() {
        Product product = new Product("Fridge", 1, 1240.99, 10);
        inventory.addProduct(product);

        assertEquals(1, inventory.getProducts().size(), "Inventory size should be 1 after adding a product.");
    }

    @Test
    void testRemoveProduct() {
        Product product1 = new Product("Stove", 1, 2020.99, 12);
        Product product2 = new Product("Oven", 2, 5000.99, 20);
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        inventory.removeProduct(1);

        assertEquals(1, inventory.getProducts().size(), "Inventory size should be 1 after removing a product.");
    }

    @Test
    void testUpdateQuantity() {
        Product product = new Product("Fridge", 1, 1240.99, 10);
        inventory.addProduct(product);

        inventory.updateQuantity(product, 15);

        assertEquals(15, product.getQuantity(), "Product quantity should be updated to 15.");
    }

    @Test
    void testViewInventory() {
        Product product1 = new Product("Stove", 1, 2020.99, 12);
        Product product2 = new Product("Oven", 2, 5000.99, 20);
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        inventory.viewInventory();

        String expectedOutput = 
            "Inventory Details:\n" +
            "====================\n" +
            "Name:         Stove\n" +
            "ID:           1\n" +
            "Price:        $2020.99\n" +
            "Quantity:     12\n" +
            "--------------------\n" +
            "Name:         Oven\n" +
            "ID:           2\n" +
            "Price:        $5000.99\n" +
            "Quantity:     20\n" +
            "--------------------\n";

        assertEquals(expectedOutput.trim(), outContent.toString().trim(), "View inventory output should match expected format and details.");
    }


    @Test
    void testCalculateInventoryValue() {
        Product product1 = new Product("Stove", 1, 2020.99, 12);
        Product product2 = new Product("Oven", 2, 5000.99, 20);
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        float totalValue = inventory.calculateInventoryValue();
        assertEquals(2020.99 * 12 + 5000.99 * 20, totalValue, 0.01, "Total inventory value should be correct.");
    }

}
