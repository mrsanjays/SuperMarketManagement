package view;

import java.util.Scanner;

import Model.Admin;
import Model.Cashier;
import Model.Database;
import Model.Employee;
import Model.Option;
import Model.Storekeeper;

public class CreateEmployee implements Option{

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		// TODO Auto-generated method stub
		System.out.print("Enter first name:"+"\n");
		String firstName = s.next();
		System.out.print("\nEnter last name:");
		String lastName = s.next();
		
		System.out.print("\nEnter email:");
		String email = s.next();
		
		System.out.print("\nEnter phone num:");
		String phoneNum = s.next();
		System.out.print("\nEnter address:");
		String address = s.next();
		
		System.out.print("\nEnter Salary(Double):");
		Double salary = s.nextDouble();
		
		System.out.print("\nEnter password");
		String password = s.next();
		
		System.out.print("\nEnter department : (0 -> Admin 1 -> Cashier 2 -> Storekeeper):");
		int department = s.nextInt();
		Employee e;
		switch (department) {
		case 0:
			e = new Admin();
			break;
		case 1:
			e = new Cashier();
			break;
		case 2:
			e = new Storekeeper();
			break;
		default:
			System.out.println("Invalid Department");
			e = new Cashier();
			break;
		
		}
		
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setEmail(email);
		e.setAddress(address);
		e.setPassword(password);
		e.setSalary(salary);
		e.setPhoneNumber(phoneNum);
		
		new Controller.CreateEmployee(e, database);
		
	}

	@Override
	public String getOption() {
		// TODO Auto-generated method stub
		return "Add New Employee";
	}

}
