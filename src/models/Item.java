package models;

public class Item {
	private String itemName = "undefined";
	
	public Item() {
		
	}
	
	public Item(String itemName) {
		this.itemName = itemName;
	}
	
	@Override
	public String toString() {
		return itemName;
	}
}
