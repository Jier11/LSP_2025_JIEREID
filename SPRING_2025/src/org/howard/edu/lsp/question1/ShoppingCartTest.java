package org.howard.edu.lspfinal.question1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ShoppingCart Tests (Q1)")
class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("Test for adding item")
    void testAddValidItem() {
        cart.addItem("Apple", 2.50);
        assertEquals(1, cart.getItemCount(), "Cart should have 1 item after adding one");
        assertEquals(2.50, cart.getTotalCost(), 0.0001, "Total cost should equal the price of the single item");
    }

    @Test
    @DisplayName("Test for adding item with zero price")
    void testAddItemWithZeroPrice() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> cart.addItem("Freebie", 0.0)
        );
        assertEquals("Price must be positive.", ex.getMessage());
    }

    @Test
    @DisplayName("Test for adding item with negative price")
    void testAddItemWithNegativePrice() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> cart.addItem("BadItem", -5.0)
        );
        assertEquals("Price must be positive.", ex.getMessage());
    }

    @Test
    @DisplayName("Test for adding item with empty name ")
    void testAddItemWithEmptyName() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> cart.addItem("", 1.0)
        );
        assertEquals("Item name cannot be empty.", ex.getMessage());
    }

    @Test
    @DisplayName("Test for removing existing item")
    void testRemoveExistingItem() {
        cart.addItem("Banana", 1.25);
        assertEquals(1, cart.getItemCount());
        cart.removeItem("Banana");
        assertEquals(0, cart.getItemCount(), "Cart should be empty after removing the item");
    }

    @Test
    @DisplayName("Test for removing non-existent item")
    void testRemoveNonExistentItem() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> cart.removeItem("Nothing")
        );
        assertTrue(ex.getMessage().contains("Item not found"));
    }

    @Test
    @DisplayName("Test total cost without discount")
    void testTotalCostWithoutDiscount() {
        cart.addItem("Milk", 3.00);
        cart.addItem("Bread", 2.00);
        assertEquals(5.00, cart.getTotalCost(), 0.0001);
    }

    @Test
    @DisplayName("Test total cost with discount")
    void testTotalCostWithDiscount() {
        cart.addItem("Soap", 4.00);
        cart.addItem("Shampoo", 6.00);
        cart.applyDiscountCode("SAVE10");
        // 10% off of 10.00 => 9.00
        assertEquals(9.00, cart.getTotalCost(), 0.0001);
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    void testTotalCostEmptyCart() {
        assertEquals(0.0, cart.getTotalCost(), 0.0001, "Empty cart should total to 0.0");
    }

    @Test
    @DisplayName("Test for applying \"SAVE10\"")
    void testApplySAVE10() {
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage(), 0.0001);
    }

    @Test
    @DisplayName("Test for applying \"SAVE20\"")
    void testApplySAVE20() {
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage(), 0.0001);
    }

    @Test
    @DisplayName("Test for applying invalid code")
    void testApplyInvalidCode() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> cart.applyDiscountCode("SAVE50")
        );
        assertEquals("Invalid discount code.", ex.getMessage());
    }

    @Test
    @DisplayName("Test cart size updates correctly after add or remove")
    void testCartSizeAfterOperations() {
        assertEquals(0, cart.getItemCount());
        cart.addItem("Pen", 1.00);
        cart.addItem("Pencil", 0.50);
        assertEquals(2, cart.getItemCount());
        cart.removeItem("Pen");
        assertEquals(1, cart.getItemCount());
    }
}
