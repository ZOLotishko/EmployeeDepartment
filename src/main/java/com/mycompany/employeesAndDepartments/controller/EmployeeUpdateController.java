package com.mycompany.employeesAndDepartments.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.employeesAndDepartments.dao.impl.EmployeesDAOImpl;
import com.mycompany.employeesAndDepartments.entity.Employees;
import com.mycompany.employeesAndDepartments.validate.EmployeeValidate;

@SuppressWarnings("serial")
public class EmployeeUpdateController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("employees_id"));
		EmployeesDAOImpl daoImpl = new EmployeesDAOImpl();
		Employees employees = daoImpl.readEmployeeByID(id);
		request.setAttribute("emp", employees);
		getServletContext().getRequestDispatcher("/jsp/updEmployee.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String id = request.getParameter("employees_id");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("mail");
		String position = request.getParameter("position");
		String salary = request.getParameter("salary");
		String date = request.getParameter("dat");
		int departments_id = Integer.parseInt(request.getParameter("departments_id"));

		EmployeeValidate validate = new EmployeeValidate(firstName, lastName, email, position, salary, date);
		validate.validate();

		if (!validate.getMessagesMap().isEmpty()){

			request.setAttribute("error", validate.getMessagesMap() );
			request.setAttribute("employees_id", id );
			request.setAttribute("departments_id", departments_id);
			request.setAttribute("first_name", firstName);
			request.setAttribute("last_name", lastName);
			request.setAttribute("mail", email);
			request.setAttribute("position", position);
			request.setAttribute("salary", salary);
			request.setAttribute("dat", date);
			request.getRequestDispatcher("/jsp/updEmployee.jsp").forward(request, response);

		}
		else {

			EmployeesDAOImpl daoImpl = new EmployeesDAOImpl();
			Employees employees = new Employees();
			employees.setEmployees_id(Integer.parseInt(id));
			employees.setFirst_name(firstName);
			employees.setLast_name(lastName);
			employees.setMail(email);
			employees.setPosition(position);
			employees.setSalary(Integer.parseInt(salary));
			employees.setDat(Date.valueOf(date));
			daoImpl.updateEmployee(employees);
			response.sendRedirect("/employeesAndDepartments/listEmployee?departments_id=" + departments_id);

		}		
	}
}
