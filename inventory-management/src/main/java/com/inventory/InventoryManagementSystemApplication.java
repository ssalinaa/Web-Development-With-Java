package com.inventory;

import com.inventory.controller.InventoryController;
import com.inventory.model.InventoryItem;
import com.inventory.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class InventoryManagementSystemApplication implements CommandLineRunner {

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private InventoryController inventoryController;

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application started successfully!");

		inventoryService.addItem("RC Car", "High-speed remote control car", 5, "S123", "pcs", "Vehicles", true);
		inventoryService.addItem("Battery Pack", "Rechargeable battery", 10, "S1231", "pcs", "Accessories", true);

		try {
			inventoryService.addItem("Battery Pack Duplicate Serial Number", "Rechargeable battery", 10, "S1231", "pcs", "Accessories", true);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex);
		}

		System.out.println("---------------------------------------");
		System.out.println("✅ Inventory items added successfully!");
		System.out.println("---------------------------------------");

		System.out.println("📌 Displaying all inventory items:");
		inventoryController.displayAllItems();
		System.out.println("---------------------------------------");

		System.out.println("🔄 Updating 'RC Car' quantity to 8...");
		inventoryController.updateItem(1, "RC Car", "High-speed remote control car", 8, "Vehicles", true);

		System.out.println("---------------------------------------");
		System.out.println("📌 Displaying updated inventory items:");
		inventoryController.displayAllItems();

		System.out.println("---------------------------------------");
		System.out.println("📌 Displaying all low stock items:");
		int threshold = 10;
		List<InventoryItem> lowCost = inventoryController.getLowStockItems(threshold);
		lowCost.stream().forEach(System.out::println);
		System.out.println("---------------------------------------");
	}
}