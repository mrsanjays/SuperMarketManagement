package Controller;

import java.sql.SQLException;

import Model.Database;


public class DeleteSection {
	public DeleteSection(int ID, Database database) {
		String delete = "DELETE FROM `sections` WHERE `ID` = '"+ID+"';";
		String deleteProducts = "DELETE FROM `products` WHERE `Section` ='"+ID+"';";
		try {
			database.getStatement().execute(delete);
			database.getStatement().execute(deleteProducts);
			System.out.println("Section Details Deleted Succesfully");
		}
		catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
}
