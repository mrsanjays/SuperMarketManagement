package Model;

public class Product {
	private int ID;
	private String name;
	private String description;
	private double price;
	private int qty;
	public Product() {
		
	}
	public Product(int iD, String name, String description, double price, int qty) {
		super();
		ID = iD;
		this.name = name;
		this.description = description;
		this.price = price;
		this.qty = qty;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public void print() {
		System.out.println("------------------------------");
		System.out.println("ID :\t\t\t"+getID());
		System.out.println("Name :\t\t\t"+getName());
		System.out.println("Description :\t\t"+getDescription());
		System.out.println("Price:\t\t\t"+getPrice()+" rupees");
		System.out.println("Quantity :\t\t"+getQty());
		System.out.println("------------------------------");
		
	}
	
	
}
