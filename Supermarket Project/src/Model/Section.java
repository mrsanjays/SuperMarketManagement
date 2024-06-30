package Model;

import java.util.ArrayList;

public class Section {
	private int ID;
	private ArrayList<Product> products;
	private String name;
	private String description;
	public Section() {
		// TODO Auto-generated constructor stub
	}
	public Section(int ID, ArrayList<Product> products,String name, String description) {
		this.name = name;
		this.ID = ID;
		this.products = products;
		this.description = description;
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
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void print() {
		System.out.println("------------------------------");
		System.out.println("ID :\t\t\t"+getID());
		System.out.println("Section Name :\t\t"+getName());
		System.out.println("Description :\t\t"+getDescription());
		System.out.println("------------------------------");
		
	}

}
