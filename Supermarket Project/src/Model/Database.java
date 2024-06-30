package Model;

import java.sql.*;
import java.sql.Statement;

public class Database {
	private String user = "root";
	private String pass = "";
	private String url = "jdbc:mysql://localhost:3306/supermarket";
	private Statement statement;
	public Database() {
		try {
			
			Connection connection = DriverManager.getConnection(url,user,pass);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public Statement getStatement() {
		return statement;
	}
}
