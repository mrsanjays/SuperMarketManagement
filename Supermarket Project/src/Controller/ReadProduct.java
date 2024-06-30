package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Database;
import Model.Product;

public class ReadProduct {
	private Product product;
	public ReadProduct(int ID ,Database database) {
		 String select = "SELECT * FROM `products` WHERE `ID` = '"+ID+"';";
		 try {
				ResultSet rs = database.getStatement().executeQuery(select);
				while(rs.next()) {
					product = new Product();
					product.setID(rs.getInt("ID"));
					product.setName(rs.getString("Name"));
					product.setDescription(rs.getString("Description"));
					product.setPrice(rs.getDouble("Price"));
					product.setQty(rs.getInt("Qty"));
					
					
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
		
	}
	public Product getProduct() {
		return product;
	}
}
