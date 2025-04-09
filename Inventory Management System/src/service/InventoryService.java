package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.InventoryItem;
import repository.InventoryItemRepository;

public class InventoryService {
    private final InventoryItemRepository itemRepository;

    public InventoryService(InventoryItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<InventoryItem> getAllItems() {
        return itemRepository.getAllItems();
    }

    public void addItem(String name, String description, int quantity, String serialNumber, String unitOfMeasurement, String categoryId, boolean isBorrowable) {
        InventoryItem item = new InventoryItem(name, description, quantity, serialNumber, unitOfMeasurement, categoryId, isBorrowable);
        itemRepository.addItem(item);
    }

    public List<InventoryItem> getLowStockItems(int threshold) {
        return itemRepository.getAllItems().stream()
                .filter(item -> item.getQuantity() < threshold)
                .collect(Collectors.toList());
    }

    public boolean updateItem(Integer id, String name, String description, int quantity, String categoryId, boolean isBorrowable) {
        Optional<InventoryItem> existingItem = itemRepository.getItemById(id);
        if(existingItem.isPresent()) {
            InventoryItem item = existingItem.get();
            item.setName(name);
            item.setDescription(description);
            item.setQuantity(quantity);
            item.setCategoryId(categoryId);
            item.setBorrowable(isBorrowable);
            return itemRepository.updateItem(item);
        }
        return false;
    }
}
