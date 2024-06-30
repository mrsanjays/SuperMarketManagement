package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Database;
import Model.Product;

public class ReadReceiptProducts {
	private ArrayList<Product> products;
	
	public ReadReceiptProducts(int receiptID,Database database) {
		// TODO Auto-generated constructor stub
		String select = "SELECT * FROM `receiptproducts` WHERE `Receipt` = '"+receiptID+"';";
		
		ArrayList<Integer> productIDs = new ArrayList<Integer>();
		ArrayList<Integer> qtys = new ArrayList<Integer>();
	    products = new ArrayList<>();
	    
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			while(rs.next()) {
				productIDs.add(rs.getInt("Product"));
				qtys.add(rs.getInt("Qty"));
				
			}
			for(int i = 0 ; i<productIDs.size();i++) {
				products.add(new ReadProduct(productIDs.get(i), database).getProduct());
				products.get(i).setQty(qtys.get(i));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public ArrayList<Product> getProducts(){
		return products;
	}
}
