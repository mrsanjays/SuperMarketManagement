package Model;


import view.CreateProduct;
import view.CreateSection;
import view.DeleteProduct;
import view.DeleteSection;
import view.ReadAllProducts;
import view.ReadAllSections;
import view.ReadSectionProducts;
import view.UpdateProduct;
import view.UpdateSection;
import view.changePassword;

public class Storekeeper extends Employee{
	public Storekeeper() {
		// TODO Auto-generated constructor stub
		generateList();
	}
	
	public Storekeeper(int ID, String firstName, String lastName, String email, String phoneNumber, String address,
			double salary,String password) {
		this.ID= ID;
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
				new CreateSection(),
				new ReadAllSections(),
				new UpdateSection(),
				new DeleteSection(),
				new CreateProduct(),
				new UpdateProduct(),
				new DeleteProduct(),
				new ReadAllProducts(),
				new ReadSectionProducts(),
				new changePassword()
		};
	}
	public int getDepartment() {
		// TODO Auto-generated method stub
		return 2;
	}

	


}
