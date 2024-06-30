package view;

import java.util.Scanner;
import Controller.ReadAllSections;

import Model.Database;
import Model.Employee;
import Model.Option;
import Model.Product;

public class CreateProduct implements Option{

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		// TODO Auto-generated method stub
		Product product = new Product();
		System.out.println("Enter Name:");
		product.setName(s.next());
		System.out.println("Enter Description:");
		product.setDescription(s.next());
		
		System.out.println("Enter Price( Double ) :");
		product.setPrice(s.nextDouble());
		
		System.out.println("Enter Quantity (in Numbers):");
		product.setQty(s.nextInt());
		
		System.out.println("Enter Section ID (-1 t show All sections):");
		int sectionId = s.nextInt();
		ReadAllSections sections = new ReadAllSections(database);
		while(sectionId < 0) {
			sections.print();
			System.out.println("Enter Section ID (-1 t show All sections):");
			 sectionId = s.nextInt();
		}
		if(!sections.getIds().contains(sectionId)) {
			System.out.println("Section Doesn't exist");
			return;
		}
		new Controller.CreateProduct(product, sectionId, database);
		
		
	}

	@Override
	public String getOption() {
		// TODO Auto-generated method stub
		return "Add new Product";
	}

}
