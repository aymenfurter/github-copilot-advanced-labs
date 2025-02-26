package com.github.copilot.lab1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    
    private ProductService productService;
    
    @BeforeEach
    void setUp() {
        productService = new ProductService();
        
        // Add some products for testing
        productService.addProduct(new Product("1", "Laptop", 1200.00, 10, "Electronics"));
        productService.addProduct(new Product("2", "Smartphone", 800.00, 20, "Electronics"));
        productService.addProduct(new Product("3", "Coffee Maker", 99.99, 5, "Kitchen"));
        productService.addProduct(new Product("4", "Desk Chair", 199.50, 8, "Furniture"));
        productService.addProduct(new Product("5", "Headphones", 150.00, 15, "Electronics"));
    }
    
    @Test
    void testAddProduct() {
        // Test adding a valid product
        assertTrue(productService.addProduct(new Product("6", "Tablet", 300.00, 12, "Electronics")));
        
        // Test adding a duplicate product should fail
        assertFalse(productService.addProduct(new Product("1", "Gaming Laptop", 1800.00, 5, "Electronics")));
        
        // Test adding a product with null values should fail
        assertFalse(productService.addProduct(null));
        assertFalse(productService.addProduct(new Product(null, "Invalid", 100.00, 1, "Test")));
        assertFalse(productService.addProduct(new Product("7", null, 100.00, 1, "Test")));
    }
    
    @Test
    void testGetProduct() {
        Product product = productService.getProduct("1");
        assertNotNull(product);
        assertEquals("Laptop", product.getName());
        assertEquals(1200.00, product.getPrice());
        
        // Test non-existent product
        assertNull(productService.getProduct("999"));
    }
    
    @Test
    void testUpdateQuantity() {
        // Test valid quantity update
        assertTrue(productService.updateQuantity("1", 15));
        assertEquals(15, productService.getProduct("1").getQuantity());
        
        // Test update for non-existent product
        assertFalse(productService.updateQuantity("999", 5));
        
        // Test with negative quantity - should fail but currently passes due to bug
        assertTrue(productService.updateQuantity("2", -5));
        assertEquals(-5, productService.getProduct("2").getQuantity());
    }
    
    @Test
    void testApplyDiscount() {
        // Apply 20% discount to Laptop
        assertTrue(productService.applyDiscount("1", 20));
        assertEquals(960.00, productService.getProduct("1").getPrice(), 0.001);
        
        // Apply invalid discount percentage
        assertFalse(productService.applyDiscount("2", 120));
        assertFalse(productService.applyDiscount("2", -10));
        
        // Apply discount to non-existent product
        assertFalse(productService.applyDiscount("999", 10));
        
        // Test with floating point precision issues
        assertTrue(productService.applyDiscount("3", 33.33));
        // Expected price should be 66.66, but due to floating point issues it might differ slightly
        assertEquals(66.66, productService.getProduct("3").getPrice(), 0.01);
    }
    
    @Test
    void testSearchProducts() {
        // Search for "phone" - should find "Smartphone" and "Headphones"
        List<Product> results = productService.searchProducts("phone");
        assertEquals(2, results.size());
        
        // Case sensitivity test - looking for "LAPTOP" should still find "Laptop"
        // This test will fail due to the bug in searchProducts method
        List<Product> caseInsensitiveResults = productService.searchProducts("LAPTOP");
        assertEquals(1, caseInsensitiveResults.size());
        
        // Search with blank text should return empty list
        List<Product> emptyResults = productService.searchProducts("");
        assertTrue(emptyResults.isEmpty());
    }
    
    @Test
    void testGetLowStockProducts() {
        // Get products with quantity less than or equal to 8
        List<Product> lowStock = productService.getLowStockProducts(8);
        assertEquals(2, lowStock.size());  // Should find Coffee Maker (5) and Desk Chair (8)
        
        // This test will fail due to the bug where the filter uses < instead of <= threshold
        assertTrue(lowStock.stream().anyMatch(p -> p.getId().equals("4")));
    }
    
    @Test
    void testGetTotalInventoryValue() {
        // Calculate total value: (1200*10) + (800*20) + (99.99*5) + (199.50*8) + (150*15) = 12000 + 16000 + 499.95 + 1596 + 2250 = 32345.95
        double expectedTotal = 32345.95;
        assertEquals(expectedTotal, productService.getTotalInventoryValue(), 0.01);
    }
    
    @Test
    void testClearInventory() {
        productService.clearInventory();
        assertNull(productService.getProduct("1"));
        assertNull(productService.getProduct("2"));
        assertEquals(0, productService.getLowStockProducts(100).size());
    }
}