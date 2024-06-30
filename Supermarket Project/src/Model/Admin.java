package Model;




import view.CreateEmployee;
import view.CreateProduct;
import view.CreateReceipt;
import view.CreateSection;
import view.DeleteEmployee;
import view.DeleteProduct;
import view.DeleteReceipt;
import view.DeleteSection;
import view.ReadAllEmployees;
import view.ReadAllProducts;
import view.ReadAllReceipts;
import view.ReadAllSections;
import view.ReadCashierReceipts;
import view.ReadMyReceipts;
import view.ReadReceipt;
import view.ReadSectionProducts;
import view.UpdateEmployee;
import view.UpdateProduct;
import view.UpdateSection;
import view.changePassword;

public class Admin extends Employee{
	
	
	public Admin() {
		// TODO Auto-generated constructor stub
		generateList();
	}
	
	public Admin(int ID, String firstName, String lastName, String email, String phoneNumber, String address,
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
				new CreateEmployee(),
				new ReadAllEmployees(),
				new UpdateEmployee(),
				new DeleteEmployee(),
				new CreateSection(),
				new ReadAllSections(),
				new UpdateSection(),
				new DeleteSection(),
				new CreateProduct(),
				new UpdateProduct(),
				new DeleteProduct(),
				new ReadAllProducts(),
				new ReadSectionProducts(),
				new CreateReceipt(),
				new ReadAllReceipts(),
				new ReadMyReceipts(),
				new ReadCashierReceipts(),
				new ReadReceipt(),
				new DeleteReceipt(),
				new changePassword()
		};
	}
	@Override
	public int getDepartment() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
