package Model;




import view.CreateReceipt;
import view.DeleteReceipt;
import view.ReadAllReceipts;
import view.ReadMyReceipts;
import view.ReadReceipt;
import view.changePassword;

public class Cashier extends Employee {
	public Cashier() {
		// TODO Auto-generated constructor stub
		generateList();
	}
	
	public Cashier(int ID, String firstName, String lastName, String email, String phoneNumber, String address,
			double salary,String password) {
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.salary = salary;
		this.password = password;
		generateList();
	}
	private void generateList() {
		this.options = new Option[] {
				new changePassword(),
				new CreateReceipt(),
				new ReadAllReceipts(),
				new ReadReceipt(),
				new ReadMyReceipts(),
				new DeleteReceipt()
		};
	}
	public int getDepartment() {
		// TODO Auto-generated method stub
		return 1;
	}

	

}
