package login;
import java.sql.*;
import java.util.*;

public class Login2
{
	private String pass;
	private String uname;

	public Login2(String uname, String pass) 
	{
		this.uname = uname;
		this.pass = pass;
	}
public boolean passv()
{
	
	   boolean flag = false;
		
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","myuser","mypassword");  
		//here sonoo is database name, root is username and password  
		
		PreparedStatement stmt=con.prepareStatement("select * from SBI where Fname=? AND pswd=?");  
		stmt.setString(1, uname);
		stmt.setString(2, pass);
	
		ResultSet rs=stmt.executeQuery(); 
		if(rs.next()) {
		  flag = true;
		}
		else
		{
			
		}
		con.close();  
		
		
		}catch(Exception e){ System.out.println(e);}  
		return flag;  	 
}	
	
		
}
