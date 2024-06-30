package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Database;
import Model.Employee;
import Model.Receipt;

public class ReadEmployeeReceipts {
	private ArrayList<Receipt> receipts;
	public ReadEmployeeReceipts(int ID,Database database) {
		// TODO Auto-generated constructor stub
		String select = "SELECT * FROM `receipts` WHERE `Cashier` ="+ID+";";
		Employee cashier = new ReadEmployee(ID, database).getEmployee();
		receipts = new ArrayList<>();
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			while(rs.next()) {
				Receipt r = new Receipt();
				r.setID(rs.getInt("ID"));
				r.setCashier(cashier);
				r.setTotal(rs.getDouble("Total"));
				r.setPayment(rs.getInt("Payment"));
				r.setPaid(rs.getDouble("Paid"));
				r.setChange(rs.getDouble("Balance"));
				receipts.add(r);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		for(int i = 0 ; i < receipts.size();i++) {
			
			receipts.get(i).setProducts(new ReadReceiptProducts(receipts.get(i).getID(), database).getProducts());
			
		}
	}
	public ArrayList<Receipt> getReceipts(){
		return receipts;
	}
	public void print() {
		System.out.println("------------------------------------------------------");
		System.out.println("ID\tCashier\t\tTotal\t\tPayment\tAmount Paid\tchange");
		for(Receipt receipt : receipts) {
			System.out.println(receipt.getID()+"\t"+receipt.getCashier().getName() +"\t" + receipt.getTotal()+" rupees\t"+receipt.getPaymentToString()+"\t"+receipt.getPaid()
		+" rupees\t"+receipt.getChange()+" rupees");
		}
		System.out.println("------------------------------------------------------");
	}
}
