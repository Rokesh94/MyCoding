package com.webapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.DAO.RegistrationDAO;
import com.model.RegistrationModel;


@WebServlet("/Registration")
public class Registration extends HttpServlet {
	//private static final long serialVersionUID = 1L;
 
	RegistrationDAO dao =new RegistrationDAO(); 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String FirstName= request.getParameter("FirstName");
		String LastName= request.getParameter("LastName");
		String UserName= request.getParameter("UserName");
		String Password= request.getParameter("Password");
		String Address= request.getParameter("Address");
		int Contact= Integer.parseInt(request.getParameter("Contact"));
		
		RegistrationModel regm= new RegistrationModel();
		
		regm.setFirstName(FirstName);
		regm.setLastName(LastName);
		regm.setUserName(UserName);
		regm.setPassword(Password);
		regm.setAddress(Address);
		regm.setContact(Contact);
		
		dao.InsertAllValues(regm);
		
		response.sendRedirect("Login.jsp");
	}

	

}
