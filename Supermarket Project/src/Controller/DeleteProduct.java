package Controller;


import java.sql.SQLException;

import Model.Database;

public class DeleteProduct {
	public DeleteProduct(int ID,Database database) {
		// TODO Auto-generated constructor stub
		String delete = "DELETE FROM `products` WHERE `ID` = '"+ID+"';";
		try {
			database.getStatement().execute(delete);
			System.out.println("Product Details Deleted Succesfully");
		}
		catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
}
