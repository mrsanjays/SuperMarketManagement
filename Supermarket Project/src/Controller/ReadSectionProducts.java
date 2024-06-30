package Controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Database;

import Model.Product;

public class ReadSectionProducts  {
	private ArrayList<Product> products;
	
	 public ReadSectionProducts (int section,Database database) {
		// TODO Auto-generated constructor stub
		 String select = "SELECT * FROM `products` WHERE `Section` = '"+section+"';";
		 products = new ArrayList<Product>();
		 //ReadAllSections sections  = new ReadAllSections(database);
		 try {
			ResultSet rs = database.getStatement().executeQuery(select);
			while(rs.next()) {
				Product product = new Product();
				product.setID(rs.getInt("ID"));
				product.setName(rs.getString("Name"));
				product.setDescription(rs.getString("Description"));
				product.setPrice(rs.getDouble("Price"));
				product.setQty(rs.getInt("Qty"));
				
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	 public void print() {
			for(Product product : products) {
				product.print();
			}
		}
	public ArrayList<Product> getProducts(){
		return products;
	}

}
