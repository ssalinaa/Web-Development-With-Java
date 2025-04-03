package com.inventory.model;

import java.time.LocalDateTime;

public class InventoryItem {
    private static int idCounter = 1;

    private Integer id;
    private String name;
    private String description;
    private int quantity;

    private String serialNumber;
    private String unitOfMeasurement;
    private String categoryId;
    private boolean isBorrowable;
    private LocalDateTime addedDate;

    public InventoryItem(String name, String description, int quantity, String serialNumber, String unitOfMeasurement, String categoryId, boolean isBorrowable) {
        this.id = idCounter++;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.serialNumber = serialNumber;
        this.unitOfMeasurement = unitOfMeasurement;
        this.categoryId = categoryId;
        this.isBorrowable = isBorrowable;
        this.addedDate = LocalDateTime.now();
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getQuantity() { return quantity; }
    public String getSerialNumber() { return serialNumber; }
    public String getUnitOfMeasurement() { return unitOfMeasurement; }
    public String getCategoryId() { return categoryId; }
    public boolean isBorrowable() { return isBorrowable; }
    public LocalDateTime getAddedDate() { return addedDate; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    public void setUnitOfMeasurement(String unitOfMeasurement) { this.unitOfMeasurement = unitOfMeasurement; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }
    public void setBorrowable(boolean isBorrowable) { this.isBorrowable = isBorrowable; }

    @Override
    public String toString() {
        return "InventoryItem:" + "\nId: " + id + "\nName: " + name + "\nDescription: " + description +
                "\nQuantity: " + quantity + "\nUnit Of Measurement: " + unitOfMeasurement +
                "\nCategory: " + categoryId + "Is borrowable?: " + isBorrowable + "\nCreated on: " + addedDate;
    }
}
