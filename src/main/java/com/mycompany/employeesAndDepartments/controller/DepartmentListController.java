package com.mycompany.employeesAndDepartments.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.employeesAndDepartments.dao.impl.DepartmentsDAOImpl;
import com.mycompany.employeesAndDepartments.entity.Departments;

@SuppressWarnings("serial")
public class DepartmentListController extends HttpServlet{
	
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	        	DepartmentsDAOImpl departmentService = new DepartmentsDAOImpl();
	            List<Departments> dep = departmentService.readDepartments();
	            req.setAttribute("dep", dep);
	            req.getRequestDispatcher("/jsp/listDepartment.jsp").forward(req, resp);

	    }

}
