package Controller;

import java.sql.SQLException;

import Model.Database;
import Model.Section;

public class CreateSection {
	public  CreateSection(Section s , Database database) {
		String insert = "INSERT INTO `sections`( `Name`, `Description`) VALUES ('"+s.getName()+"','"+s.getDescription()+"')";
		try {
			database.getStatement().execute(insert);
			System.out.println("Section Created Succesfully");
		}
		catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
}
