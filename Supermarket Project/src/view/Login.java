package view;

import java.util.Scanner;

import Model.Database;
import Model.Employee;
import Model.Option;

public class Login implements Option {

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to supermarket management system");
		System.out.print("Enter your email:");
		String email = s.next();
		System.out.print("\nEnter your Password:");
		String password = s.next();
		Controller.Login login = new Controller.Login(email,password,database);
		if(login.isLoggedIn()) {
			Employee employee = login.getUser();
			System.out.println("Welcome "+employee.getFirstName());
			employee.showList(s,database);
		}
		else {
			System.out.println("Wrong email or password!");
			System.out.println("Try Again");
		}
	}

	@Override
	public String getOption() {
		// TODO Auto-generated method stub
		return "Login";
	}

}
