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
	
	@Override
	public String toString() {
		return storeName;
	}
}
