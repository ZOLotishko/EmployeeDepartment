package com.mycompany.employeesAndDepartments.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.employeesAndDepartments.dao.impl.DepartmentsDAOImpl;
import com.mycompany.employeesAndDepartments.entity.Departments;
import com.mycompany.employeesAndDepartments.validate.DepartmentValidate;


@SuppressWarnings("serial")
public class DepartmentAddController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("id", "0");
		req.getRequestDispatcher("/jsp/addDepartment.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//    	request.setCharacterEncoding("Cp1251");

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String specification = request.getParameter("specification");


		DepartmentValidate validate = new DepartmentValidate( name , specification);
		validate.validate();

		if (!validate.getMessagesMap().isEmpty()) {
			request.setAttribute("error", validate.getMessagesMap());
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("specification", specification);
			request.getRequestDispatcher("/jsp/addDepartment.jsp").forward(request, response);
		} else {
			Departments department = new Departments();
			department.setName(name);
			department.setSpecification(specification);
			DepartmentsDAOImpl departmentsDAOImpl = new DepartmentsDAOImpl();
			//                DepartmentService departmentService = new DepartmentServiceImpl();
			departmentsDAOImpl.createDepartment(department);
			response.sendRedirect("/employeesAndDepartments/department");
		}
	}
}
