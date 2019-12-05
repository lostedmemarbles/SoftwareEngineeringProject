package models;
import java.util.ArrayList;

public class Store {

	ArrayList<Item> items = new ArrayList<Item>();
	private String name;
	public Store() {
		
	}
	
	public Store(String name) {
		this.name = name;
	}
}
