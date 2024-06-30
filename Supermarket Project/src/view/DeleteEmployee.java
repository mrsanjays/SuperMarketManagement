package view;

import java.util.Scanner;

import Controller.ReadAllEmployees;
import Model.Database;
import Model.Employee;
import Model.Option;

public class DeleteEmployee implements Option{

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		// TODO Auto-generated method stub
		System.out.println("Enter employee ID (-1 to show All employees):");
		int ID = s.nextInt();
		while(ID<0) {
			new ReadAllEmployees(database).print();
			System.out.println("Enter employee ID (-1 to show All employees):");
			ID = s.nextInt();
			
		}
		new Controller.DeleteEmployee(ID, database);
		
	}

	@Override
	public String getOption() {
		// TODO Auto-generated method stub
		return "Fire Employee";
	}

}
