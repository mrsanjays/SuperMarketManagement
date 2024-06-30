package view;

import java.util.Scanner;

import Model.Database;
import Model.Employee;
import Model.Option;

public class changePassword implements Option{

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		// TODO Auto-generated method stub
		System.out.println("Enter old Password:");
		String oldPass = s.next();
		if(!oldPass.equals(user.getPassword())) {
			System.out.println("Incorrect Password , Try Again");
			return;
		}
		System.out.println("Enter new password:");
		String newPass = s.next();
		System.out.println("Confirm Password:");
		String confirmPass= s.next();
		
		if(!newPass.equals(confirmPass)) {
			System.out.println("Password not Matched");
			return;
		}
		new Controller.changePassword(confirmPass, user, database);
	}

	@Override
	public String getOption() {
		// TODO Auto-generated method stub
		return "Change Password";
	}

}
