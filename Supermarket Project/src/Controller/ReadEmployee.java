package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Admin;
import Model.Cashier;
import Model.Database;
import Model.Employee;
import Model.Storekeeper;

public class ReadEmployee {
	private Employee e;

    public ReadEmployee(int ID, Database database) {
        String select = "SELECT * FROM `employees` WHERE `ID` = " + ID + ";";
        
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            if (rs.next()) {
                String firstname = rs.getString("FirstName");
                String lastname = rs.getString("LastName");
                String email = rs.getString("Email");
                String phoneNumber = rs.getString("PhoneNumber");
                String address = rs.getString("Address");
                String password = rs.getString("Password");
                double salary = rs.getDouble("Salary");
                int department = rs.getInt("Department");

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
            } else {
                System.out.println("Employee not found with ID: " + ID);
                e = null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            e = null;
        }
    }

    public Employee getEmployee() {
        return e;
    }

    public void printEmployee() {
        if (e != null) {
            e.print();
        } else {
            System.out.println("No employee to print.");
        }
    }
//	private Employee e;
//	public ReadEmployee(int ID , Database database) {
//		String select = "SELECT * FROM `employees` WHERE `ID` = " + ID + ";";
//		
//		
//		try {
//			ResultSet rs = database.getStatement().executeQuery(select);
//			rs.next();
//			
//			String firstname = rs.getString("FirstName");
//			String lastname = rs.getString("LastName");
//			String email = rs.getString("Email");
//			String phoneNumber = rs.getString("PhoneNumber");
//			String address = rs.getString("Address");
//			String password = rs.getString("Password");
//			double salary = rs.getDouble("Salary");
//			int department = rs.getInt("Department");
//			
//			Employee ex;
//			switch (department) {
//			case 0:
//				ex = new Admin();
//				break;
//			case 1:
//				ex = new Cashier();
//				break;
//			case 2:
//				ex= new Storekeeper();
//				break;
//			default:
//				System.out.println("Invalid Department");
//				ex = new Cashier();
//				break;
//			
//			}
//			ex.setID(ID);
//			ex.setFirstName(firstname);
//			ex.setLastName(lastname);
//			ex.setEmail(email);
//			ex.setAddress(address);
//			ex.setPassword(password);
//			ex.setSalary(salary);
//			ex.setPhoneNumber(phoneNumber);
//		} catch (SQLException exx) {
//			// TODO Auto-generated catch block
//			exx.printStackTrace();
//		}
//		 
//	}
//	public Employee getEmployee() {
//		return e;
//	}
//	public void printEmployee() {
//		
//		e.print();
//		
//	}
}
