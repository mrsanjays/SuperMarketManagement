package view;

import java.util.Scanner;

import Model.Database;
import Model.Employee;
import Model.Option;

public class ReadAllProducts implements Option{

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		// TODO Auto-generated method stub
		new Controller.ReadAllProducts(database).print();
	}

	@Override
	public String getOption() {
		// TODO Auto-generated method stub
		return "View All Products";
	}

}
