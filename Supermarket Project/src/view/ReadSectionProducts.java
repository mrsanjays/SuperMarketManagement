package view;

import java.util.Scanner;

import Controller.ReadAllSections;
import Model.Database;
import Model.Employee;
import Model.Option;

public class ReadSectionProducts implements Option {

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		// TODO Auto-generated method stub
		System.out.println("Enter section ID (-1 to show all sections):");
		int sec = s.nextInt();
		while(sec < 0){
			new ReadAllSections(database).print();
			System.out.println("Enter section ID (-1 to show all sections):");
			 sec = s.nextInt();
		}
		new Controller.ReadSectionProducts(sec,database).print();;
	}

	@Override
	public String getOption() {
		// TODO Auto-generated method stub
		return "View Section Products";
	}

}
