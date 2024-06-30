package view;

import java.util.Scanner;

import Controller.ReadAllProducts;
import Controller.ReadProduct;
import Model.Database;
import Model.Employee;
import Model.Option;
import Model.Product;

public class UpdateProduct implements Option {

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		System.out.println("Enter Product ID (-1 to show All Products:)");
		int ID = s.nextInt();
		while(ID < 0) {
			new ReadAllProducts(database).print();
			System.out.println("Enter Product ID (-1 to show All Products:)");
			 ID = s.nextInt();
		}
		Product product = new ReadProduct(ID, database).getProduct();
		System.out.println("Enter Product name (-1 to keep " +product.getName()+ "):");
		String name = s.next();
		if(!name.equals("-1")) {
			product.setName(name);
		}
		
		System.out.println("Enter Product Description (-1 to keep " +product.getDescription()+ "):");
		String Description = s.next();
		if(!Description.equals("-1")) {
			product.setDescription(Description);
		}
		
		System.out.println("Enter Product Price (-1 to keep " +product.getPrice()+ " rupees ):");
		Double price = s.nextDouble();
		if(price != -1) {
			product.setPrice(price);
		}
		System.out.println("Enter Product Quatity (-1 to keep " +product.getQty()+ "):");
		int qty = s.nextInt();
		if(qty != -1) {
			product.setQty(qty);
		}
		new Controller.UpdateProduct(product, database);
	}

	@Override
	public String getOption() {
		// TODO Auto-generated method stub
		return "Update Product";
	}

}
