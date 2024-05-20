package com.vaakruthi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException; 

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet; 
@WebServlet("/LoginPage") 



public class LoginPage  extends GenericServlet{

	//private ServletResponse res;
	//private ServletRequest req;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		String mobile=req.getParameter("mb");
		String pass=req.getParameter("pwd");
		 String url = "jdbc:mysql://localhost:3306?user=root&password=12345";  String query = "select * from teja15.userdetails where mobile=? and password=?"; 
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection connect=DriverManager.getConnection(url);
			 PreparedStatement ps=connect.prepareStatement(query);
			 ps.setString(1, mobile);
			 ps.setString(2,pass);
			 ResultSet rs=ps.executeQuery();
			 PrintWriter writer=res.getWriter();
			 
			 if(rs.next()) {
				 writer.println("LOGIN SUCESSFULL");
				 
			 }
			 else {
				 writer.println("Invalid mobile number");
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}

}
