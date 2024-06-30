package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Database;
import Model.Section;

public class ReadSection {
	private Section section;
	public ReadSection(int ID,Database database) {
		String select = "SELECT * FROM `sections` WHERE `ID` ='"+ID+"';";
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			rs.next();
			section = new Section();
			section.setID(rs.getInt("ID"));
			section.setName(rs.getString("Name"));
			section.setDescription(rs.getString("Description"));
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public Section getSection() {
		return section;
	}
	public void print() {
		section.print();
	}
}
