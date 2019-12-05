package models;

import main.RandomIDMaker;

public class Item {
	
	private String itemName = "undefined";
	private int id;
	private Department department;
	private int units;
	private float price;
	private Markdown markdown;
	
	public Item() {
		RandomIDMaker randomIDMaker = new RandomIDMaker();
		id = randomIDMaker.generateIDNumber();
	}
	
	public Item(String itemName) {
		this();
		this.itemName = itemName;
	}
	
	public Item(String itemName, Department department, int units, float price, Markdown markdown) {
		this(itemName);
		this.department = department;
		this.units = units;
		this.price = price;
		this.markdown = markdown;
	}
	
	public Item(String itemName, Department department, int units, float price, Markdown markdown, int id) {
		this.itemName = itemName;
		this.id = id;
		this.department = department;
		this.units = units;
		this.price = price;
		this.markdown = markdown;
	}
	
	@Override
	public String toString() {
		return itemName;
	}
	
	public String getName() {
		return itemName;
	}
	
	public void setName(String itemName) {
		this.itemName = itemName;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Markdown getMarkdown() {
		return markdown;
	}

	public void setMarkdown(Markdown markdown) {
		this.markdown = markdown;
	}

	
}
