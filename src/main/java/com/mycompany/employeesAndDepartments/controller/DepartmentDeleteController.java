package com.mycompany.employeesAndDepartments.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.employeesAndDepartments.dao.impl.DepartmentsDAOImpl;

@SuppressWarnings("serial")
public class DepartmentDeleteController extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int action = Integer.parseInt(req.getParameter("delete"));

		DepartmentsDAOImpl departmentService = new DepartmentsDAOImpl();
		departmentService.deleteDepartment(action);

		resp.sendRedirect("/employeesAndDepartments/department");

	}
}
