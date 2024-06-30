package Controller;

import java.sql.SQLException;

import Model.Database;

public class DeleteEmployee {
	public  DeleteEmployee(int ID, Database database) {
		String delete = "DELETE FROM `employees` WHERE `ID` = '"+ID+"';";
		try {
			database.getStatement().execute(delete);
			System.out.println("Employee's Details Deleted Succesfully");
		}
		catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
}
