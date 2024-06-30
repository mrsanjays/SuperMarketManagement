package Controller;

import java.sql.SQLException;

import Model.Database;
import Model.Product;

public class CreateProduct {

	public CreateProduct(Product product , int section, Database database) {
		String insert = "INSERT INTO `products`(`Name`, `Description`, `Price`, `Qty`, `Section`) VALUES ('"+product.getName()+"','"+product.getDescription()+"','"+product.getPrice()+"','"+product.getQty()+"','"+section+"');";
		try {
			database.getStatement().execute(insert);
			System.out.println("Product Created Succesfully");
		}
		catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}

}
