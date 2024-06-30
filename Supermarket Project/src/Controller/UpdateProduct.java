package Controller;

import java.sql.SQLException;

import Model.Database;
import Model.Product;

public class UpdateProduct {
	public UpdateProduct(Product product , Database database) {
		String update = "UPDATE `products` SET `Name`='"+product.getName()+"'"
				+ ",`Description`='"+product.getDescription()+"',`Price`='"+product.getPrice()+"'"
				+ ",`Qty`='"+product.getQty()+"' WHERE `ID` = '"+product.getID()+"';";
		
		try {
			database.getStatement().execute(update);
			System.out.println("Product Details Updated Succesfully");
		}
		catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
}
