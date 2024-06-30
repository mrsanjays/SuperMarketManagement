package view;

import java.util.Scanner;

import Model.Database;
import Model.Employee;
import Model.Option;

public class DeleteReceipt implements Option {

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		// TODO Auto-generated method stub
		System.out.println("Enter receipt ID (-1 to show all ):");
		int ID = s.nextInt();
		while(ID < 0) {
			new Controller.ReadAllReceipt(database).print();
			System.out.println("Enter receipt ID (-1 to show all ):");
			 ID = s.nextInt();
		}
		new Controller.DeleteReceipt(ID, database);
	}

	@Override
	public String getOption() {
		// TODO Auto-generated method stub
		return "Remove Receipt";
	}

}
