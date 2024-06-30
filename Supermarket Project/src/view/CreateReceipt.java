package view;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.ReadAllSections;
import Controller.ReadProduct;
import Model.Database;
import Model.Employee;
import Model.Option;
import Model.Product;
import Model.Receipt;

public class CreateReceipt implements Option {

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Integer> IDs = new ArrayList<>();
		ArrayList<Integer> Qty = new ArrayList<>();
		 ReadAllSections readAllSections= new ReadAllSections(database);
		int i;
		do {
			readAllSections.printSectionsWithProduct();
			System.out.println("Select Products then enter -1 to proceed to checkout");
			i = s.nextInt();
			if( i>0) {
				IDs.add(i);
				System.out.println("Enter Qtys :");
				Qty.add(s.nextInt());
				System.out.println("--------------------------------------");
			}
		}while(i > 0);
		
		ArrayList<Product> products = new ArrayList<Product>();
		for(int j = 0 ; j<IDs.size();j++) {
			products.add(new ReadProduct(IDs.get(j), database).getProduct());
			products.get(j).setQty(Qty.get(j));
		}
		double total = 0;
		System.out.println("--------------------------------------");
		System.out.println("Check your order:");
		System.out.println("--------------------------------------");
		for(Product product : products) {
			System.out.println(product.getName()+"\t"+product.getPrice()+" rupees\t" + product.getQty());
			total += product.getPrice() * product.getQty();
		}
		System.out.println("--------------------------------------");
		System.out.println("Total Amount :" + total +" rupees");
		System.out.println("--------------------------------------");
		
		System.out.println("1. Continue\n2. Cancel\nType Here:");
		int cont = s.nextInt();
		if(cont != 1) {
			return;
		}
		System.out.println("Select Payment : \n1. Cash\n2. UPI / Debit Card / Credit Card\nType Here:");
		int pay = s.nextInt();
		while (pay < 1 && pay > 2) {
			System.out.println("Invalid Payment Methos");
			System.out.println("Select Payment : \n1. Cash\n2. UPI / Debit Card / Credit Card\nType Here:");
		    pay = s.nextInt();
		}
		double paid,change;
		 if(pay == 1) {
			 System.out.println("Enter Paid:");
				paid = s.nextDouble();
				while(paid < total) {
					System.out.println("Insufficient Amount :");
					System.out.println("Do you want to continue\n1. Yes\2. No\nType Here:");
					if(s.nextInt()==2) {
						System.out.println("Thank You !! Come Again Later!!");
						return;
					}
					System.out.println("Enter Paid:");
				    paid = s.nextDouble();
				}
			    change = paid - total;
				System.out.println("--------------------------------------");
				System.out.println("Your Change = "+change+" rupees");
				System.out.println("--------------------------------------");
		 }
		 else {
			 paid = total;change = 0;
			 System.out.println("--------------------------------------");
			System.out.println("Payment Done");
			System.out.println("--------------------------------------");
		 }
		
		
		
		Receipt receipt = new Receipt();
		receipt.setCashier(user);
		receipt.setProducts(products);
		receipt.setTotal(total);
		receipt.setPayment(pay);
		receipt.setPaid(paid);
		receipt.setChange(change);
		new Controller.CreateReceipt(receipt, database);
	}

	@Override
	public String getOption() {
		// TODO Auto-generated method stub
		return "Create Receipt";
	}

}
