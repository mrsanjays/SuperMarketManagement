package view;

import java.util.Scanner;

import Controller.ReadAllProducts;
import Model.Database;
import Model.Employee;
import Model.Option;

public class DeleteProduct implements Option {

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		System.out.println("Enter Product ID (-1 to show All Products:)");
		int ID = s.nextInt();
		ReadAllProducts readAllProducts = new ReadAllProducts(database);
		while(ID < 0) {
			readAllProducts.print();
			System.out.println("Enter Product ID (-1 to show All Products:)");
			 ID = s.nextInt();
		}
		if(!readAllProducts.getIDs().contains(ID)) {
			System.out.println("Invalid Product ID");
			return;
		}
		new Controller.DeleteProduct(ID, database);
	}

	@Override
	public String getOption() {
		// TODO Auto-generated method stub
		return "Remove Product";
	}

}
