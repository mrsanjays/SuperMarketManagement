package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;


import Model.Database;
import Model.Product;
import Model.Receipt;

public class CreateReceipt {
	public CreateReceipt(Receipt r, Database database ) {
		
		int ID = -1;
		String insertReceipt = "INSERT INTO `receipts`( `Cashier`, `Total`, `Payment`, `Paid`, `Balance`) VALUES ('"+r.getCashier().getID()+"','"+r.getTotal()+"'"
				+ ",'"+r.getPayment()+"','"+r.getPaid()+"','"+r.getChange()+"');";
		String selectID = "SELECT LAST_INSERT_ID();";
		
		try {
			database.getStatement().execute(insertReceipt);
			ResultSet rs =  database.getStatement().executeQuery(selectID);
			rs.next();
			ID = rs.getInt("LAST_INSERT_ID()");
			
		}
		catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		
		for(Product product :r.getProducts()) {
			String insertProd = "INSERT INTO `receiptproducts`(`Product`, `Qty`, `Receipt`)"
					+ " VALUES ('"+product.getID()+"','"+product.getQty()+"','"+ID+"')";

			try {
				if(ID != -1)
				 database.getStatement().execute(insertProd);
				
			}
			catch (SQLException ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}
		System.out.println("Receipt Added Successfully");
	}
}
