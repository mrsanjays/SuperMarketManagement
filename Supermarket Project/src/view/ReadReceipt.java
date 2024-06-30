package view;

import java.util.Scanner;

import Model.Database;
import Model.Employee;
import Model.Option;
import Model.Product;
import Model.Receipt;

public class ReadReceipt implements Option {

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter Employee's ID (-1 to show All Receipts) :");
		int ID = s.nextInt();
		while(ID < 0) {
			new Controller.ReadAllReceipt(database).print();
			System.out.println("Enter Employee's ID (-1 to show All employees) :");
			ID = s.nextInt();
		}
		
		Receipt receipt = new Controller.ReadReceipt(ID, database).getReceipt();
		System.out.println("-----------------------------------------");
		System.out.println("ID:\t\t"+receipt.getID());
		System.out.println("Cashier:\t"+receipt.getCashier().getName());
		System.out.println("-----------------------------------------");
		System.out.println();
		for(Product product : receipt.getProducts()) {
			
			System.out.println("  |" +product.getName() +"\t"+product.getPrice()+"\t"+product.getQty()+"|");
			
		}
		System.out.println();
		System.out.println("-----------------------------------------");
		
		System.out.println("Total      : "+receipt.getTotal() +" rs");
		System.out.println("Payment    : "+receipt.getPaymentToString() );
		System.out.println("Paid Amount: "+receipt.getPaid() +" rs");
		System.out.println("Balance    : "+receipt.getChange() +" rs");
		System.out.println("-----------------------------------------");

		
	}

	@Override
	public String getOption() {
		// TODO Auto-generated method stub
		return "View Receipt";
	}

}
