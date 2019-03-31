package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public static Connection connection = null ; 
	
	static{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DatabaseConstants.DATABASE_NAME , DatabaseConstants.USER_NAME, DatabaseConstants.USER_PASS);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

	public static Connection getConnection() {
		return connection ; 
	}
}
