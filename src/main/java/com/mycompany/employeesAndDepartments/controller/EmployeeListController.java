package com.mycompany.employeesAndDepartments.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.employeesAndDepartments.dao.impl.EmployeesDAOImpl;
import com.mycompany.employeesAndDepartments.entity.Employees;

@SuppressWarnings("serial")
public class EmployeeListController extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		EmployeesDAOImpl daoImpl = new EmployeesDAOImpl();
		String d_id = request.getParameter("departments_id");
		int id = Integer.parseInt(d_id);
		
		List<Employees> emp = daoImpl.readEmployeeByIDDepartment(id);
		
		request.setAttribute("departments_id", d_id);
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("/jsp/listEmployee.jsp").forward(request, response);
	}

}
