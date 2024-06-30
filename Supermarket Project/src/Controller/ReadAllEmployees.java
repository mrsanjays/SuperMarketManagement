package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Admin;
import Model.Cashier;
import Model.Database;
import Model.Employee;
import Model.Storekeeper;

public class ReadAllEmployees {
	private ArrayList<Employee> employees;
	public ReadAllEmployees(Database database) {
		String select = "SELECT * FROM `employees`;";
		 employees = new ArrayList<Employee>();
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			while(rs.next()) {
				int ID = rs.getInt("ID");
				String firstname = rs.getString("FirstName");
				String lastname = rs.getString("LastName");
				String email = rs.getString("Email");
				String phoneNumber = rs.getString("PhoneNumber");
				String address = rs.getString("Address");
				String password = rs.getString("Password");
				double salary = rs.getDouble("Salary");
				int department = rs.getInt("Department");
				
				Employee e;
				switch (department) {
				case 0:
					e = new Admin();
					break;
				case 1:
					e = new Cashier();
					break;
				case 2:
					e = new Storekeeper();
					break;
				default:
					System.out.println("Invalid Department");
					e = new Cashier();
					break;
				
				}
				e.setID(ID);
				e.setFirstName(firstname);
				e.setLastName(lastname);
				e.setEmail(email);
				e.setAddress(address);
				e.setPassword(password);
				e.setSalary(salary);
				e.setPhoneNumber(phoneNumber);
				employees.add(e);
			}
			
		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
	
	public void print() {
		
		for(Employee e : employees) {
			e.print();
			System.out.println("--------------------------------------");
		}
//		System.out.println("---------------------------");
//		System.out.println("ID\tName\tEmail\tPhoneNumber\tAddress\tSalary\tDept");
//		for(Employee e : employees) {
//			System.out.println(e.getID()+"\t"+ e.getFirstName() +"\t"+ e.getLastName()+"\t"+e.getEmail()+"\t"+e.getPhoneNumber()+"\t"+e.getAddress()+"\t"+e.getSalary()+"\t"+e.getDepartmentToString());
//		}
//		System.out.println("---------------------------");
	}
}
