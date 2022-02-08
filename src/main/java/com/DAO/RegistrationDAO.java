package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.RegistrationModel;

public class RegistrationDAO 
{
	String url= "jdbc:mysql://localhost:3306/Employee";
	String user="root";
	String pass= "Anuesh3120";
	String query= "Insert into empl(FirstName,LastName,UserName,Password,Address,Contact)values(?,?,?,?,?,?)";
	

	
	public boolean InsertAllValues(RegistrationModel reg) 
	{
		
		
		try {
			
//			RegistrationModel rm= new RegistrationModel();
//			rm.setFirstName("Norris");
//			rm.setLastName("Zhang");
//			rm.setUserName("xxx");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url,user,pass);
			Statement stmt= con.createStatement();
		
			PreparedStatement st= con.prepareStatement(query);
			//st.setInt(1, 1);
			st.setString(1, reg.getFirstName());
			st.setString(2, reg.getLastName());
			st.setString(3, reg.getUserName());
			st.setString(4, reg.getPassword());
			st.setString(5, reg.getAddress());
			st.setInt(6, reg.getContact());
			
			System.out.println("Inserted");
			
			 st.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false; 
		
	}
	
	public boolean login(String UserName, String Password) throws ClassNotFoundException, SQLException {
	
		String Sql= "Select * from empl where UserName=? and Password=?";
		Class.forName("com.mysql.jdbc.Driver");
				Connection con= DriverManager.getConnection(url,user,pass);
				Statement stmt= con.createStatement();
			
				PreparedStatement st= con.prepareStatement(Sql);
				
				st.setString(1, UserName);
				st.setString(2, Password);
				ResultSet rs= st.executeQuery();
				
				while(rs.next()) {
		return true;
				}
		return false;
		
	}
}
