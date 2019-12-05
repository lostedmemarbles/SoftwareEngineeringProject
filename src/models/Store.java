package models;
import java.util.ArrayList;

public class Store {

	ArrayList<Item> items = new ArrayList<Item>();
	private String storeName;
	public Store() {
		
	}
	
	public Store(String storeName) {
		this.storeName = storeName;
	}
	
	// The general idea behind this return type being bool is to perhaps
	// show a popup saying an item exists in the caller class if returned false
	public boolean addItem(Item item) {
		
		if (itemInStore(item.getName())) {
			return false;
		}
		items.add(item);
		return true;
	}
	
	public void removeItem(Item item) {
		
		String itemToRemoveName = item.getName().toUpperCase();
		String itemCurrentIterationName;
		Item foundItem = null;
		
		for (Item i : items) {
			itemCurrentIterationName = i.getName().toUpperCase();
			if (itemCurrentIterationName.compareTo(itemToRemoveName) == 0) {
				foundItem = i;
				break;
			}
		}
		
		if (foundItem != null) {
			items.remove(foundItem);
		}
		
	}
	
	public boolean itemInStore(String itemName) {
		
		itemName = itemName.toUpperCase();
		String itemCurrentIterationName;
		
		for (Item i : items) {
			itemCurrentIterationName = i.getName().toUpperCase();
			if (itemCurrentIterationName.compareTo(itemName) == 0) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return storeName;
	}
	
	// Accessors
	public String getName() {
		return storeName;
	}
}
