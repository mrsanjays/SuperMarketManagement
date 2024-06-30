package supermarket;


import Model.Database;

import view.Login;

import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
//		Employee admin = new Admin(0,"Admin","0","admin0@supermarket.com","0000","Address 0",1000,"000");
//		Database database = new Database();
//		new CreateEmployee(admin,database);
		new Login().oper(null,new Scanner(System.in),new Database());
	}
}
