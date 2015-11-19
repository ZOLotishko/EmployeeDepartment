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
public class EmployeeAddController extends HttpServlet{
	
	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String id = request.getParameter("departments_id");		
		request.setAttribute("dep_id", id);
		request.getRequestDispatcher("/jsp/addEmployee.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		EmployeesDAOImpl daoImpl = new EmployeesDAOImpl();
		
//		int id = Integer.parseInt(request.getParameter("employees_id"));
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("mail");
		String position = request.getParameter("position");
		String salary = request.getParameter("salary");
		String date = request.getParameter("dat");
		String departments_id = request.getParameter("departments_id");
		
		EmployeeValidate employeeVal = new EmployeeValidate(first_name, last_name, email, position, salary, date);
		employeeVal.validate();
		
		if(!employeeVal.getMessagesMap().isEmpty()){
            request.setAttribute("error", employeeVal.getMessagesMap());
            request.setAttribute("first_name", first_name);
            request.setAttribute("last_name", last_name);
            request.setAttribute("mail", email);
            request.setAttribute("position", position);
            request.setAttribute("salary", salary);
            request.setAttribute("dat", date);
            request.setAttribute("dep_id", departments_id);
            
           
            request.getRequestDispatcher("/jsp/addEmployee.jsp").forward(request, response);
        }else {

            Employees employee = new Employees();
            int s = Integer.parseInt(salary);
            int d = Integer.parseInt(departments_id);
            
            employee.setFirst_name(first_name);
            employee.setLast_name(last_name);
            employee.setMail(email);
            employee.setPosition(position);
            employee.setSalary(s);
            employee.setDat(Date.valueOf(date));
            employee.setDepartments_id(d);

            daoImpl.createEmployee(employee);
            response.sendRedirect("/employeesAndDepartments/listEmployee?departments_id=" + departments_id);
        }
		
		
	}
}
