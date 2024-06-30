package Controller;

import java.sql.SQLException;

import Model.Database;
import Model.Section;

public class UpdateSection {
	public UpdateSection(Section section , Database database) {
		String update = "UPDATE `sections` SET `Name`='" + section.getName() + "', `Description`='" + section.getDescription() + "' WHERE `ID`='" + section.getID() + "';";
		try {
			database.getStatement().execute(update);
			System.out.println("Section Details Updated Succesfully");
		}
		catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
}
