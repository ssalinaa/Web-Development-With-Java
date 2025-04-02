package repository;

import model.InventoryItem;

import java.util.*;

public class InventoryItemRepository {
    private static Map<Integer, InventoryItem> itemTable = new HashMap<>();

    public void addItem(InventoryItem item) {
        if(item != null) {
            itemTable.put(item.getId(), item);
        }
    }

    public boolean deleteItemById(Integer id) {
        if(itemTable.containsKey(id)) {
            itemTable.remove(id);
            return true;
        }
        return false;
    }

    public Optional<InventoryItem> getItemById(Integer id) {
        return Optional.ofNullable(itemTable.get(id));
    }

    public List<InventoryItem> getAllItems() {
        return new ArrayList<>(itemTable.values());
    }

    public boolean updateItem(InventoryItem updatedItem) {
        if(itemTable.containsKey(updatedItem.getId())) {
            itemTable.put(updatedItem.getId(), updatedItem);
            return true;
        }
        return false;
    }
}
