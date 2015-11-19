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
public class DepartmentUpdateController extends HttpServlet{


	//	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		DepartmentsDAOImpl daoImpl = new DepartmentsDAOImpl();
		Departments departments = daoImpl.readDepartmentByID(id);
		request.setAttribute("id", departments.getId());
		request.setAttribute("name", departments.getName());
		request.setAttribute("specification", departments.getSpecification());

		getServletContext().getRequestDispatcher("/jsp/updDepartment.jsp").forward(request, response);

	}

	//	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String specification = request.getParameter("specification");

		DepartmentValidate validate = new DepartmentValidate( name, specification);
		validate.validate();

		if (!validate.getMessagesMap().isEmpty()){
			request.setAttribute("error", validate.getMessagesMap());
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("specification", specification);
			request.getRequestDispatcher("/jsp/updDepartment.jsp").forward(request, response);
		}
		else{
			Departments department = new Departments();
			department.setId(id);
			department.setName(name);
			department.setSpecification(specification);
			DepartmentsDAOImpl daoImpl = new DepartmentsDAOImpl();
			daoImpl.updateDepartment(department);

			response.sendRedirect("/employeesAndDepartments/department");

		}
	}
}
