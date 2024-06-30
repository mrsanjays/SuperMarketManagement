package view;

import java.util.Scanner;


import Model.Database;
import Model.Employee;
import Model.Option;

public class ReadMyReceipts implements Option{

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		// TODO Auto-generated method stub
		new Controller.ReadEmployeeReceipts(user.getID(), database).print();
	}

	@Override
	public String getOption() {
		// TODO Auto-generated method stub
		return "View My Receipts";
	}

}
