package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Database;
import Model.Product;

public class ReadAllProducts {
	private ArrayList<Product> products;
	
	 public ReadAllProducts(Database database) {
		// TODO Auto-generated constructor stub
		 String select = "SELECT * FROM `products` ;";
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
	 public ArrayList<Integer> getIDs(){
		 ArrayList<Integer> IDs = new ArrayList<Integer>();
		 for(Product p:products) {
			 IDs.add(p.getID());
		 }
		 return IDs;
	 }
}
