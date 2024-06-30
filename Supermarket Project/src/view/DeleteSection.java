package view;

import java.util.Scanner;

import Controller.ReadAllSections;
import Model.Database;
import Model.Employee;
import Model.Option;

public class DeleteSection implements Option {

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		// TODO Auto-generated method stub
		System.out.println("Enter Section ID(-1 to show all sections):");
		int ID = s.nextInt();
		ReadAllSections readAllSections = new ReadAllSections(database);
		while(ID<0) {
			readAllSections.print();
			System.out.println("Enter Section ID(-1 to show all sections):");
			ID = s.nextInt();
		}
		if(!readAllSections.getIds().contains(ID)) {
			System.out.println("Invalid ID");
		}
		System.out.println("Warning! Deleting this section leads to Delete of All products in this Section");
		System.out.println("Enter YES / NO :");
		String s1 = s.next();
		s1.toLowerCase();
		if(s1.equals("yes")) {
			new Controller.DeleteSection(ID, database);
		}
		else {
			System.out.println("No Action Performed!");
			return;
		}
	}

	@Override
	public String getOption() {
		// TODO Auto-generated method stub
		return "Remove Section";
	}

}
