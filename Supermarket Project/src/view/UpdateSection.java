package view;

import java.util.Scanner;

import Controller.ReadSection;
import Model.Database;
import Model.Employee;
import Model.Option;
import Model.Section;

public class UpdateSection implements Option{

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		// TODO Auto-generated method stub
		System.out.println("Enter Section ID (-1 to show all sections): ");
		int ID = s.nextInt();
		while(ID<0) {
			new Controller.ReadAllSections(database).print();
			System.out.println("Enter Section ID (-1 to show all sections): ");
			 ID = s.nextInt();
		}
		Section section = new ReadSection(ID, database).getSection();
		System.out.println("Enter section name( -1 to keep " +section.getName()+"):");
		String name = s.next();
		if(!name.equals("-1")) {
			section.setName(name);
		}
		System.out.println("Enter section description (-1 to keep " +section.getDescription()+"):");
		
		 String description = s.next();
		if(!description.equals("-1")) {
			section.setDescription(description);
		}
		new Controller.UpdateSection(section, database);
	}

	@Override
	public String getOption() {
		// TODO Auto-generated method stub
		return "Update Section Details";
	}

}
