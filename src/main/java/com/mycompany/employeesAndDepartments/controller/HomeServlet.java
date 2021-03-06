package com.mycompany.employeesAndDepartments.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HomeServlet extends HttpServlet{
	
	private Date currentDate;
	 private DateFormat dateFormat;
	 
	@Override
	public void init(){
		
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		currentDate = new Date();
		
	}
	@Override
	public void doGet( HttpServletRequest req , HttpServletResponse pos){
		req.setAttribute( "date" ,dateFormat.format(currentDate) );
		try {
			getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req, pos);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
}
