package view;

import java.util.Scanner;

import Model.Database;
import Model.Employee;
import Model.Option;
import Model.Section;

public class CreateSection implements Option {

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the Section Name:");
		String sectionName = s.next();
		System.out.println("Enter the Description:");
		String description = s.next();
		Section sec = new Section();
		sec.setName(sectionName);
		sec.setDescription(description);
		new Controller.CreateSection(sec, database);
		
		
	}

	@Override
	public String getOption() {
		// TODO Auto-generated method stub
		return "Add new Section";
	}

}
