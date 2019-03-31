package login;
import java.sql.*;
import java.util.*;

import javax.sound.midi.Synthesizer;
import database.DatabaseConnection;

public class ForgotPass 
{
	private String MNAME;
	private String ATMPIN;
	private String epass;
	private String atmpin;
	private Connection con = DatabaseConnection.getConnection() ; 
	static PreparedStatement stmt1;
	private ResultSet rs1 = null ;
	/*public ForgotPass(String MNAME,String ATMPIN)
	{
		this.MNAME=MNAME;
		this.ATMPIN=ATMPIN;
	}*/
	public boolean fgps(String MNAME,String ATMPIN)
	{
	
		
		   boolean flag = false;
			
			try
			{  
		
			PreparedStatement stmt=con.prepareStatement("select Mname from SBI where Mname=? AND ATMPIN=?");
			stmt.setString(1, MNAME);
			stmt.setString(2, ATMPIN);
			
			ResultSet rs=stmt.executeQuery(); 
		
			if(rs.next()) {
				
			  flag = true;
			}
			else
			{
			
			}
			
						
			}catch(Exception e){ System.out.println(e);}  
			return flag; 
		
	}
	public boolean resetPassword(String epass,String atmpin)
	{
		boolean flag=false;
		
		try
		{
			
			PreparedStatement stmt1=con.prepareStatement("update SBI set pswd = ? where ATMPIN = ?");
			System.out.println(epass + " " + atmpin	);
			
			stmt1.setString(1, epass);
			stmt1.setString(2, atmpin);
			int count = stmt1.executeUpdate();
			if(count > 0)
			{
								
			flag=true;	
			}
			else
			{
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public void details()
	{
		
	}
	
}
