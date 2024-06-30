package Controller;

import java.sql.SQLException;

import Model.Database;
import Model.Employee;

public class changePassword {
	public changePassword(String password,Employee user,Database database) {
		String update = "UPDATE `employees` SET `Password`='"+password+"' WHERE `ID` ='"+user.getID()+"';";
		try {
			database.getStatement().execute(update);
			System.out.println("Password updated Succesfully");
		}
		catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
}

