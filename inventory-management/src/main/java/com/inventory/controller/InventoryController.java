package com.inventory.controller;

import com.inventory.model.InventoryItem;
import com.inventory.service.InventoryService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Component
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void displayAllItems() {
        List<InventoryItem> items = inventoryService.getAllItems();
        if(items.isEmpty()) {
            System.out.println("No inventory items available.");
        } else {
            items.forEach(item -> System.out.println("Item: " + item.getName() + ", Quantity: " + item.getQuantity()));
        }
    }

    public List<InventoryItem> getLowStockItems(int threshold) {
        return inventoryService.getLowStockItems(threshold);
    }

    public void updateItem(Integer id, String name, String description, int quantity, String categoryId, boolean isBorrowable) {
        boolean success = inventoryService.updateItem(id, name, description, quantity, categoryId, isBorrowable);
        if(success) {
            System.out.println("Item updated automatically.");
        } else {
            System.out.println("Update failed. Item not found.");
        }
    }
}
