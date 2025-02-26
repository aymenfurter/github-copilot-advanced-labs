package com.github.copilot.lab1.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service that manages a collection of products with operations
 * for inventory management and pricing.
 */
public class ProductService {
    private final Map<String, Product> inventory = new HashMap<>();

    /**
     * Adds a product to the inventory
     * @param product the product to add
     * @return true if added successfully, false if product with same ID already exists
     */
    public boolean addProduct(Product product) {
        if (product == null || product.getId() == null || product.getName() == null) {
            return false;
        }
        
        if (inventory.containsKey(product.getId())) {
            return false;
        }
        
        inventory.put(product.getId(), product);
        return true;
    }
    
    /**
     * Retrieves a product by its ID
     * @param id the product ID
     * @return the product or null if not found
     */
    public Product getProduct(String id) {
        return inventory.get(id);
    }
    
    /**
     * Updates the quantity of a product in inventory
     * @param id the product ID
     * @param newQuantity the new quantity (can be negative as per current test expectations)
     * @return true if updated successfully, false if product not found
     */
    public boolean updateQuantity(String id, int newQuantity) {
        // Revert negative quantity validation to align with test expectations
        Product product = inventory.get(id);
        if (product == null) {
            return false;
        }
        
        product.setQuantity(newQuantity);
        return true;
    }
    
    /**
     * Applies a discount percentage to a product's price
     * @param id the product ID
     * @param discountPercent the discount percentage (0-100)
     * @return true if the discount was applied, false otherwise
     */
    public boolean applyDiscount(String id, double discountPercent) {
        Product product = inventory.get(id);
        
        if (product == null) {
            return false;
        }
        
        if (discountPercent < 0 || discountPercent > 100) {
            return false;
        }
        
        double discountAmount = product.getPrice() * (discountPercent / 100);
        product.setPrice(product.getPrice() - discountAmount);
        
        return true;
    }
    
    /**
     * Searches products by name containing the given text (case insensitive)
     * @param searchText the text to search for
     * @return list of matching products
     */
    public List<Product> searchProducts(String searchText) {
        if (searchText == null || searchText.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        // Fix: Make search case insensitive by converting strings to lower case
        String searchLower = searchText.toLowerCase();
        return inventory.values().stream()
                .filter(product -> product.getName().toLowerCase().contains(searchLower))
                .collect(Collectors.toList());
    }
    
    /**
     * Gets a list of products that are low in stock
     * @param threshold the low stock threshold quantity
     * @return list of products below or equal to the threshold
     */
    public List<Product> getLowStockProducts(int threshold) {
        // Fix: Include products with quantity equal to threshold
        return inventory.values().stream()
                .filter(product -> product.getQuantity() <= threshold)
                .collect(Collectors.toList());
    }
    
    /**
     * Gets the total inventory value (price * quantity for all products)
     * @return the total value
     */
    public double getTotalInventoryValue() {
        // Fix: Multiply price with quantity
        return inventory.values().stream()
                .mapToDouble(product -> product.getPrice() * product.getQuantity())
                .sum();
    }
    
    /**
     * Clears all products from the inventory
     */
    public void clearInventory() {
        inventory.clear();
    }
}